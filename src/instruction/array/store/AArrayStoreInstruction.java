package instruction.array.store;

import object.Reference;

public class AArrayStoreInstruction extends AbstractArrayStoreInstruction {
	
	public static final String OPCODE = "53";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected void checkValueType(Reference valueReference) {
		checkJavaObject(valueReference);
	}

}
