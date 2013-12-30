package instruction.integer.istore;


public class Istore0Instruction extends AbstractIstoreInstruction {
	
	public static final String OPCODE = "3B";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected int getStoreIndex(byte[] bytecode, int bytecodeIndex) {
		return 0;
	}

}
