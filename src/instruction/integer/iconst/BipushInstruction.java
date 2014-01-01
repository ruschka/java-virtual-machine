package instruction.integer.iconst;


public class BipushInstruction extends IconstInstruction {
	
	public static final String OPCODE = "10";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected Integer getValue(byte[] bytecode, int bytecodeIndex) {
		return getIntegerFormNextByte(bytecode, bytecodeIndex);
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 2;
	}


}
