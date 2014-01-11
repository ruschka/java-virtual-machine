package enviroment;

import java.util.HashSet;
import java.util.Set;

import object.AbstractObject;

public class Heap {
	
	private Set<AbstractObject> objects = new HashSet<AbstractObject>();
	
	public Set<AbstractObject> getObjects() {
		return objects;
	}

	public void setObjects(Set<AbstractObject> objects) {
		this.objects = objects;
	}

	public void addObject(AbstractObject object) {
		objects.add(object);
	}
	
	public int getSize() {
		return objects.size();
	}
	
}
