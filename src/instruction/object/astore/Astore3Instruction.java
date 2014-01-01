package instruction.object.astore;

import instruction.store.Store3Instruction;
import object.Reference;

public class Astore3Instruction extends Store3Instruction {
	
	public static final String OPCODE = "4E";

	@Override
	public String getOpcode() {
		return OPCODE;
	}
	
	@Override
	protected void checkType(Reference reference) {
		checkComplexObject(reference);
	}

}
