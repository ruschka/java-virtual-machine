package instruction.object;

import instruction.AbstractInstruction;
import object.Reference;
import enviroment.Frame;
import enviroment.Heap;

public class PutFieldInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "B5";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		Reference valueRefence = frame.pop();
		Reference objectRefence = frame.pop();
		
		return getBytecodeIndex(bytecodeIndex);
	}

}
