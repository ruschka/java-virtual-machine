package instruction.integer.iload;

import instruction.load.Load3Instruction;
import object.Reference;

public class Iload3Instruction extends Load3Instruction {
	
	public static final String OPCODE = "1D";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkInteger(reference);
	}

}
