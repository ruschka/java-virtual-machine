package instruction.util;

import enviroment.Frame;
import enviroment.Heap;
import instruction.AbstractInstruction;

public class GotoInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "A7";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		int offset = getIntegerFromNextTwoBytes(bytecode, bytecodeIndex);
		return bytecodeIndex + offset;
	}

}
