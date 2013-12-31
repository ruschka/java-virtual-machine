package instruction.store;


public abstract class Store2Instruction extends AbstractStoreInstruction {

	@Override
	protected int getStoreIndex(byte[] bytecode, int bytecodeIndex) {
		return 2;
	}
	
}
