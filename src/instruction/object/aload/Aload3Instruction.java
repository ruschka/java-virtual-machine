package instruction.object.aload;

import instruction.load.Load3Instruction;
import object.Reference;

public class Aload3Instruction extends Load3Instruction {
	
	public static final String OPCODE = "2D";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkObject(reference);
	}

}
