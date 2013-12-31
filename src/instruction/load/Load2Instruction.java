package instruction.load;


public abstract class Load2Instruction extends AbstractLoadInstruction {

	@Override
	protected int getLoadIndex(byte[] bytecode, int bytecodeIndex) {
		return 2;
	}
	
}
