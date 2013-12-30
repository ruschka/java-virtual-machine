package enviroment;

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;

public class ClassLoader {
	
	public static JavaClass loadClass(String clazz) throws ClassNotFoundException {
		return Repository.lookupClass(clazz);
	}

}
