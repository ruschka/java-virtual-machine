package instruction.object.astore;

import object.Reference;
import instruction.store.Store0Instruction;

public class Astore0Instruction extends Store0Instruction {
	
	public static final String OPCODE = "4B";

	@Override
	public String getOpcode() {
		return OPCODE;
	}
	
	@Override
	protected void checkType(Reference reference) {
		checkComplexObject(reference);
	}

}
