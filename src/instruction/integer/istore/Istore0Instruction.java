package instruction.integer.istore;

import instruction.store.Store0Instruction;
import object.Reference;

public class Istore0Instruction extends Store0Instruction {
	
	public static final String OPCODE = "3B";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkInteger(reference);		
	}

}
