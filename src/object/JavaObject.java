package object;

import java.util.HashMap;
import java.util.Map;

import org.apache.bcel.classfile.JavaClass;

public class JavaObject extends AbstractObject<Object> {
	
	private JavaClass javaClass;
	
	private Map<String, Reference> fields = new HashMap<String, Reference>();

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
	
	public void putField(String field, AbstractObject<?> object) {
		fields.put(field, new Reference(object));
	}
	
	public Reference getField(String field) {
		return fields.get(field);
	}


}
