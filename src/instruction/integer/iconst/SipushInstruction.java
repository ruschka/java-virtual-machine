package instruction.integer.iconst;

public class SipushInstruction extends IconstInstruction {
	
	public static final String OPCODE = "11";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected Integer getValue(byte[] bytecode, int bytecodeIndex) {
		return getIntegerFromNextTwoBytes(bytecode, bytecodeIndex);
	}

	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 3;
	}
	
}
