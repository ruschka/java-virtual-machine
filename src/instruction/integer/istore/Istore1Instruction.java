package instruction.integer.istore;


public class Istore1Instruction extends AbstractIstoreInstruction {
	
	public static final String OPCODE = "3C";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected int getStoreIndex(byte[] bytecode, int bytecodeIndex) {
		return 1;
	}

}
