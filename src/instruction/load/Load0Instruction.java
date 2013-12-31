package instruction.load;


public abstract class Load0Instruction extends AbstractLoadInstruction {

	@Override
	protected int getLoadIndex(byte[] bytecode, int bytecodeIndex) {
		return 0;
	}
	
}
