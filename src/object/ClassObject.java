package object;

public class ClassObject extends ComplexObject {
	
	private boolean initialized = false;

	public boolean isInitialized() {
		return initialized;
	}
	
	public void initialize() {
		initialized = true;
	}

}
