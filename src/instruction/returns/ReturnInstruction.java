package instruction.returns;

import object.Heap;
import enviroment.Frame;
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
