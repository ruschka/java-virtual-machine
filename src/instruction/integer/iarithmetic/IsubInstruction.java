package instruction.integer.iarithmetic;


public class IsubInstruction extends IArithmeticInstruction {
	
	public static final String OPCODE = "64";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected Integer getResult(Integer operand1, Integer operand2) {
		return operand1 - operand2;
	}

}
