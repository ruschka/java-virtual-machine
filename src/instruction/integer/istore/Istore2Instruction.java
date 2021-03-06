package instruction.integer.istore;

import instruction.store.Store2Instruction;
import object.Reference;


public class Istore2Instruction extends Store2Instruction {
	
	public static final String OPCODE = "3D";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkInteger(reference);
	}

}
