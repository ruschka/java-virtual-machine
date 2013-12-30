package instruction.integer.iload;

import instruction.AbstractInstruction;
import object.Heap;
import object.Reference;
import enviroment.Frame;

public class Iload1Instruction extends AbstractInstruction {
	
	public static final String OPCODE = "1B";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		Reference reference = frame.getLocal(1);
		checkInteger(reference);
		frame.push(reference);
		return bytecodeIndex;
	}

}