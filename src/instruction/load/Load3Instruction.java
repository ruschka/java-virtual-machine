package instruction.load;


public abstract class Load3Instruction extends AbstractLoadInstruction {

	@Override
	protected int getLoadIndex(byte[] bytecode, int bytecodeIndex) {
		return 3;
	}
	
}
