package instruction.object;

import instruction.AbstractInstruction;
import enviroment.Frame;
import enviroment.Heap;

public class GetFieldInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "B4";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		
		return getBytecodeIndex(bytecodeIndex);
	}

}
