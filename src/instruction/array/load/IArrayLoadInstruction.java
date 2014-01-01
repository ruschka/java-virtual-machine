package instruction.array.load;

import object.Reference;

public class IArrayLoadInstruction extends AbstractArraLoadInstruction {
	
	public static final String OPCODE = "2E";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkValue(Reference valueReference) {
		checkInteger(valueReference);
	}

}
