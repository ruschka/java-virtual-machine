package object;

import org.apache.bcel.classfile.JavaClass;

public class JavaObject extends ComplexObject {
	
	private JavaClass javaClass;

	public JavaObject(JavaClass javaClass) {
		super();
		this.javaClass = javaClass;
	}
	
	public JavaClass getJavaClass() {
		return javaClass;
	}

}
