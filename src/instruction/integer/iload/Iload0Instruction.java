package instruction.integer.iload;

import instruction.load.Load0Instruction;
import object.Reference;

public class Iload0Instruction extends Load0Instruction {
	
	public static final String OPCODE = "1A";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkInteger(reference);
	}

}
