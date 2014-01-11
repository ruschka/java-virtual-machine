package enviroment;

import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;
import instruction.InstructionPool;

import org.apache.bcel.classfile.Method;

public class MethodRunner {
	
	private Method method;
	private Frame frame;
	private Heap heap;
	private IGarbageCollector garbageCollector;
	
	public MethodRunner(Method method, Frame frame, Heap heap, IGarbageCollector garbageCollector) {
		super();
		this.method = method;
		this.frame = frame;
		this.heap = heap;
		this.garbageCollector = garbageCollector;
	}

	public void run() {
		int bytecodeIndex = 0;
		byte[] bytecode = method.getCode().getCode();
		while (bytecodeIndex < bytecode.length) {
			AbstractInstruction instruction = InstructionPool.getInstruction(bytecode[bytecodeIndex]);
			bytecodeIndex = instruction.run(frame, heap, bytecode, bytecodeIndex, garbageCollector);
			garbageCollector.run(heap, frame);
		}
	}

}
