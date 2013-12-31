package instruction.returns;

import object.Reference;
import enviroment.Frame;
import enviroment.Heap;
import instruction.AbstractInstruction;

public class IReturnInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "AC";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		Reference reference = frame.pop();
		checkInteger(reference);
		frame.getParent().push(reference);
		return getBytecodeIndex(bytecodeIndex);
	}

}
