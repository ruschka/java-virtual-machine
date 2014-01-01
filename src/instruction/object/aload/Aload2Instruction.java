package instruction.object.aload;

import instruction.load.Load2Instruction;
import object.Reference;

public class Aload2Instruction extends Load2Instruction {
	
	public static final String OPCODE = "2C";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkComplexObject(reference);
	}

}
