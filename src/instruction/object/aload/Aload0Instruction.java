package instruction.object.aload;

import object.Reference;
import instruction.load.Load0Instruction;

public class Aload0Instruction extends Load0Instruction {
	
	public static final String OPCODE = "2A";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkComplexObject(reference);
	}

}
