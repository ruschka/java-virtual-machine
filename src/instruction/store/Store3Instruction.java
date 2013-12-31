package instruction.store;


public abstract class Store3Instruction extends AbstractStoreInstruction {

	@Override
	protected int getStoreIndex(byte[] bytecode, int bytecodeIndex) {
		return 3;
	}
	
}
