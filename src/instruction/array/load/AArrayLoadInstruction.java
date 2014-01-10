package instruction.array.load;

import object.Reference;

public class AArrayLoadInstruction extends AbstractArrayLoadInstruction {
	
	public static final String OPCODE = "32";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkValue(Reference valueReference) {
		checkComplexObject(valueReference);
	}

}
