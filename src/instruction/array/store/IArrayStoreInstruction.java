package instruction.array.store;

import object.Reference;

public class IArrayStoreInstruction extends AbstractArrayStoreInstruction {
	
	public static final String OPCODE = "4F";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkValueType(Reference valueReference) {
		checkInteger(valueReference);
	}

}
