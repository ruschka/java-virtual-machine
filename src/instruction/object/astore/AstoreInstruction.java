package instruction.object.astore;

import instruction.store.StoreInstruction;
import object.Reference;

public class AstoreInstruction extends StoreInstruction {
	
	public static final String OPCODE = "3A";

	@Override
	public String getOpcode() {
		return OPCODE;
	}
	
	@Override
	protected void checkType(Reference reference) {
		checkObject(reference);
	}

}
