package instruction.load;


public abstract class Load1Instruction extends AbstractLoadInstruction {

	@Override
	protected int getLoadIndex(byte[] bytecode, int bytecodeIndex) {
		return 1;
	}
	
}
