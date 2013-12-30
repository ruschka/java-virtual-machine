package instruction.integer.istore;

import instruction.AbstractInstruction;
import object.Heap;
import object.Reference;
import enviroment.Frame;

public class Istore3Instruction extends AbstractInstruction {
	
	public static final String OPCODE = "3E";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		Reference reference = frame.pop();
		checkInteger(reference);
		frame.setLocal(3, reference);
		return bytecodeIndex;
	}

}
