package instruction.integer.istore;


public class Istore3Instruction extends AbstractIstoreInstruction {
	
	public static final String OPCODE = "3E";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected int getStoreIndex(byte[] bytecode, int bytecodeIndex) {
		return 3;
	}

}
