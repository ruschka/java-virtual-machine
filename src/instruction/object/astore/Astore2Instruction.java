package instruction.object.astore;

import instruction.store.Store2Instruction;
import object.Reference;

public class Astore2Instruction extends Store2Instruction {
	
	public static final String OPCODE = "4D";

	@Override
	public String getOpcode() {
		return OPCODE;
	}
	
	@Override
	protected void checkType(Reference reference) {
		checkObject(reference);
	}

}
