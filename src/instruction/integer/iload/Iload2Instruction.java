package instruction.integer.iload;

import instruction.load.Load2Instruction;
import object.Reference;

public class Iload2Instruction extends Load2Instruction {
	
	public static final String OPCODE = "1C";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkInteger(reference);
	}

}
