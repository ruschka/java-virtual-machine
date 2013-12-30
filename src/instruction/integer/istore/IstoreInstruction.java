package instruction.integer.istore;


public class IstoreInstruction extends AbstractIstoreInstruction {
	
	public static final String OPCODE = "36";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected int getStoreIndex(byte[] bytecode, int bytecodeIndex) {
		return bytecode[bytecodeIndex];
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 1;
	}

}
