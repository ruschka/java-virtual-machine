package instruction.integer.istore;

import instruction.store.Store3Instruction;
import object.Reference;


public class Istore3Instruction extends Store3Instruction {
	
	public static final String OPCODE = "3E";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkInteger(reference);
	}

}
