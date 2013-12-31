package instruction.object.astore;

import instruction.store.Store1Instruction;
import object.Reference;

public class Astore1Instruction extends Store1Instruction {
	
	public static final String OPCODE = "4C";

	@Override
	public String getOpcode() {
		return OPCODE;
	}
	
	@Override
	protected void checkType(Reference reference) {
		checkObject(reference);
	}

}
