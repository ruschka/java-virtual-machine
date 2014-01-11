package garbagecollector;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import object.AbstractObject;
import object.ArrayObject;
import object.ComplexObject;
import object.Reference;
import enviroment.ClassLoader;
import enviroment.Frame;
import enviroment.Heap;

public class BakerGarbageCollector extends GarbageCollector {

	@Override
	protected void collect(Heap heap, Frame actualFrame) {
		Set<AbstractObject> oldObjects = heap.getObjects();
		Set<AbstractObject> newObjects = new HashSet<AbstractObject>();
		collectFrame(oldObjects, newObjects, actualFrame);
		collectClassObjects(oldObjects, newObjects);
		heap.setObjects(newObjects);
	}

	private void collectFrame(Set<AbstractObject> oldObjects, Set<AbstractObject> newObjects, Frame actualFrame) {
		if (actualFrame == null) {
			return;
		}
		collectFrame(oldObjects, newObjects, actualFrame.getParent());
		switchToNewObjects(oldObjects, newObjects, Arrays.asList(actualFrame.getLocalVariables()));
		switchToNewObjects(oldObjects, newObjects, actualFrame.getStack());
	}
	
	private void collectClassObjects(Set<AbstractObject> oldObjects, Set<AbstractObject> newObjects) {
		switchToNewObjects(oldObjects, newObjects, ClassLoader.getClassObjects());
	}
	
	private void switchToNewObjects(Set<AbstractObject> oldObjects, Set<AbstractObject> newObjects, Iterable<Reference> references) {
		for (Reference reference : references) {
			switchToNewObjects(oldObjects, newObjects, reference);
		}
	}
	
	private void switchToNewObjects(Set<AbstractObject> oldObjects, Set<AbstractObject> newObjects, Reference reference) {
		if (reference == null) {
			return;
		}
		AbstractObject object = reference.getObject();
		if (newObjects.contains(object)) {
			return; // nad timto objektem uz garbage collector bezel
		}
		newObjects.add(object);
		oldObjects.remove(object);
		checkComplexObject(oldObjects, newObjects, object);
		checkArrayObject(oldObjects, newObjects, object);
	}
	
	private void checkComplexObject(Set<AbstractObject> oldObjects, Set<AbstractObject> newObjects, AbstractObject object) {
		if (object instanceof ComplexObject) {
			ComplexObject complexObject = (ComplexObject) object;
			Collection<Reference> references = complexObject.getReferences();
			for (Reference reference : references) {
				switchToNewObjects(oldObjects, newObjects, reference);
			}
		}
	}
	
	private void checkArrayObject(Set<AbstractObject> oldObjects, Set<AbstractObject> newObjects, AbstractObject object) {
		if (object instanceof ArrayObject) {
			ArrayObject arrayObject = (ArrayObject) object;
			Reference reference = null;
			for (int i = 0; i < arrayObject.getLength(); i++) {
				if ((reference = arrayObject.getValue(i)) != null) {
					switchToNewObjects(oldObjects, newObjects, reference);
				}
			}
		}
	}

}
