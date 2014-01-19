package enviroment;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import object.ClassObject;
import object.Reference;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

public class ClassLoader {
	
	/**
	 * Mapa uchovajici objekty trid. Objekty trid slouzi pro uchovani statickych poli.
	 */
	private static Map<String, Reference> CLASSES = new HashMap<String, Reference>();
	
	public static JavaClass loadClass(String clazz) {
		try {
			return Repository.lookupClass(clazz);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Class " + clazz + " not found", e);
		}
	}
	
	public static Method getMethodByName(JavaClass clazz, String methodName, String methodSignature) {
		if (clazz == null) {
			throw new IllegalStateException("Method " + methodName + " not found.");
		}
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (methodName.equals(method.getName()) && methodSignature.equals(method.getSignature())) {
				return method;
			}
		}
		try {
			return getMethodByName(clazz.getSuperClass(), methodName, methodSignature);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Method " + methodName + " not found.", e);
		}
	}
	
	public static Reference getClassObject(String clazz, Heap heap) {
		Reference reference = CLASSES.get(clazz);
		if (reference == null) {
			ClassObject classObject = new ClassObject();
			heap.addObject(classObject);
			reference = new Reference(classObject);
			CLASSES.put(clazz, reference);
		}
		return reference;
	}
	
	public static Collection<Reference> getClassObjects() {
		return CLASSES.values();
	}

}
