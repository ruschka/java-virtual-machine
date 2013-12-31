package instruction.object.aload;

import instruction.load.LoadInstruction;
import object.Reference;

public class AloadInstruction extends LoadInstruction {
	
	public static final String OPCODE = "19";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkObject(reference);
	}

}
