package enviroment;

import instruction.AbstractInstruction;
import instruction.InstructionPool;

import org.apache.bcel.classfile.Method;

public class MethodRunner {
	
	private Method method;
	private Frame frame;
	private Heap heap;
	
	public MethodRunner(Method method, Frame frame, Heap heap) {
		super();
		this.method = method;
		this.frame = frame;
		this.heap = heap;
	}

	public void run() {
		int bytecodeIndex = 0;
		byte[] bytecode = method.getCode().getCode();
		while (bytecodeIndex < bytecode.length) {
			AbstractInstruction instruction = InstructionPool.getInstruction(bytecode[bytecodeIndex++]);
			bytecodeIndex = instruction.run(frame, heap, bytecode, bytecodeIndex);
		}
	}

}
