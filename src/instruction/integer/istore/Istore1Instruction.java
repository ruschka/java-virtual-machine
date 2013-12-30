package instruction.integer.istore;

import instruction.AbstractInstruction;
import object.Heap;
import object.Reference;
import enviroment.Frame;

public class Istore1Instruction extends AbstractInstruction {
	
	public static final String OPCODE = "3C";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		Reference reference = frame.pop();
		checkInteger(reference);
		frame.setLocal(1, reference);
		return bytecodeIndex;
	}

}
