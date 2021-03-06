package instruction.integer.istore;

import instruction.store.Store1Instruction;
import object.Reference;

public class Istore1Instruction extends Store1Instruction {
	
	public static final String OPCODE = "3C";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkInteger(reference);
	}

}
