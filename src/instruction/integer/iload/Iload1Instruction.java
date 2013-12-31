package instruction.integer.iload;

import instruction.load.Load1Instruction;
import object.Reference;

public class Iload1Instruction extends Load1Instruction {
	
	public static final String OPCODE = "1B";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkInteger(reference);
	}

}
