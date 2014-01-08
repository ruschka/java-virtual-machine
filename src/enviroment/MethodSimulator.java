package enviroment;

import java.util.List;

import object.Reference;

public abstract class MethodSimulator {
	
	public abstract void run(Frame frame, Heap heap, List<Reference> arguments);
	
	public String getKey() {
		return getMethodName() + ";" + getMethodSignature();
	}
	
	protected abstract String getMethodName();
	
	protected abstract String getMethodSignature();

}
