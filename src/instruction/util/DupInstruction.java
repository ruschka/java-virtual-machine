package instruction.util;

import object.Reference;
import enviroment.Frame;
import enviroment.Heap;
import instruction.AbstractInstruction;

public class DupInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "59";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		Reference reference = frame.pop();
		frame.push(reference.getObject());
		frame.push(reference.getObject());
		return getBytecodeIndex(bytecodeIndex);
	}

}
