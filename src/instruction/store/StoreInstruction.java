package instruction.store;


public abstract class StoreInstruction extends AbstractStoreInstruction {

	@Override
	protected int getStoreIndex(byte[] bytecode, int bytecodeIndex) {
		return bytecode[bytecodeIndex];
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 1;
	}
	
}
