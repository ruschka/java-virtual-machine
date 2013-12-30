package object;

import org.apache.bcel.classfile.JavaClass;

public class JavaObject extends AbstractObject<Object> {
	
	private JavaClass javaClass;

	public JavaObject(JavaClass javaClass) {
		super();
		this.javaClass = javaClass;
	}

	@Override
	public Object getValue() {
		throw new UnsupportedOperationException("Object cannot return value");
	}
	
	public JavaClass getJavaClass() {
		return javaClass;
	}


}
