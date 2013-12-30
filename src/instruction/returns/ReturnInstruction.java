package instruction.returns;

import enviroment.Frame;
import enviroment.Heap;
import instruction.AbstractInstruction;

public class ReturnInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "B1";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		return bytecodeIndex;
	}

}
