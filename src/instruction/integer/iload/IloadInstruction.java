package instruction.integer.iload;

import object.Reference;
import instruction.load.LoadInstruction;

public class IloadInstruction extends LoadInstruction {
	
	public static final String OPCODE = "15";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkType(Reference reference) {
		checkInteger(reference);
	}

}
