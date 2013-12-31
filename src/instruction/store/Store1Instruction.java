package instruction.store;


public abstract class Store1Instruction extends AbstractStoreInstruction {

	@Override
	protected int getStoreIndex(byte[] bytecode, int bytecodeIndex) {
		return 1;
	}
	
}
