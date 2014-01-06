package instruction.array.store;

import object.Reference;

public class BArrayStoreInstruction extends AbstractArrayStoreInstruction {
	
	public static final String OPCODE = "54";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkValueType(Reference valueReference) {
		checkInteger(valueReference);
	}

}
