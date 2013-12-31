package instruction.load;


public abstract class LoadInstruction extends AbstractLoadInstruction {

	@Override
	protected int getLoadIndex(byte[] bytecode, int bytecodeIndex) {
		return getIntegerFormNextByte(bytecode, bytecodeIndex);
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 2;  
	}
	
}
