package instruction.object.aload;

import instruction.load.Load1Instruction;
import object.Reference;

public class Aload1Instruction extends Load1Instruction {
	
	public static final String OPCODE = "2B";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkComplexObject(reference);
	}

}
