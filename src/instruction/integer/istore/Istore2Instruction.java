package instruction.integer.istore;


public class Istore2Instruction extends AbstractIstoreInstruction {
	
	public static final String OPCODE = "3D";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected int getStoreIndex(byte[] bytecode, int bytecodeIndex) {
		return 2;
	}

}
