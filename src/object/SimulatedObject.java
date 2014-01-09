package object;

import instruction.AbstractInstruction.FieldOrMethodInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enviroment.Frame;
import enviroment.Heap;
import enviroment.MethodSimulator;

public abstract class SimulatedObject<T> extends AbstractObject {
	
	protected final Map<String, MethodSimulator> METHOD_SIMULATORS = new HashMap<String, MethodSimulator>();
	
	protected T object;
	
	public SimulatedObject() {
		
	}
	
	public SimulatedObject(T object) {
		this.object = object;
	}
	
	public void setObject(T object) {
		if (this.object != null) {
			throw new IllegalStateException("Object already set.");
		}
		this.object = object;
	}
	
	public T getObject() {
		return object;
	}
	
	public abstract String getClassName();
	
	public void simulateMethod(Frame frame, Heap heap, FieldOrMethodInfo methodInfo, List<Reference> arguments) {
		MethodSimulator methodSimulator = METHOD_SIMULATORS.get(methodInfo.name + ";" + methodInfo.signature);
		if (methodSimulator == null) {
			throw new IllegalStateException("Method simulator cannot be null - object class: " + getClassName() + 
					", method class: " + methodInfo.className + ", method: " + methodInfo.name + ", signature: " + methodInfo.signature);
		}
		methodSimulator.run(frame, heap, arguments);
	}
	
	protected void addMethodSimulator(MethodSimulator methodSimulator) {
		METHOD_SIMULATORS.put(methodSimulator.getKey(), methodSimulator);
	}
	

}
