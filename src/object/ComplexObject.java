package object;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class ComplexObject extends AbstractObject {
	
	private Map<String, Reference> fields = new HashMap<String, Reference>();
	
	public void putField(String field, AbstractObject object) {
		fields.put(field, new Reference(object));
	}
	
	public Reference getField(String field) {
		return fields.get(field);
	}
	
	public Collection<Reference> getReferences() {
		return fields.values();
	}

}
