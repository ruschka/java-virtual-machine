package enviroment;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

public class ClassLoader {
	
	public static JavaClass loadClass(String clazz) {
		try {
			return Repository.lookupClass(clazz);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Class " + clazz + " not found", e);
		}
	}
	
	public static Method getMethodByName(JavaClass clazz, String methodName) {
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (methodName.equals(method.getName())) {
				return method;
			}
		}
		throw new IllegalStateException("Method " + methodName + " not found.");
	}

}
