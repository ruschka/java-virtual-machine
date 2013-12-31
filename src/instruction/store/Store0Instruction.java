package instruction.store;


public abstract class Store0Instruction extends AbstractStoreInstruction {

	@Override
	protected int getStoreIndex(byte[] bytecode, int bytecodeIndex) {
		return 0;
	}
	
}
