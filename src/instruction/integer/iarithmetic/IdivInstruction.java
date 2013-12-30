package instruction.integer.iarithmetic;

public class IdivInstruction extends IArithmeticInstruction {
	
	public static final String OPCODE = "6C";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected Integer getResult(Integer operand1, Integer operand2) {
		return operand1 / operand2;
	}

}
