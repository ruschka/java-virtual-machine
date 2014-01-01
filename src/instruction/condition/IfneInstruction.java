package instruction.condition;

/**
 * ifne succeeds if and only if value != 0
 * @author ruschka
 *
 */
public class IfneInstruction extends IfInstruction {
	
	public static final String OPCODE = "9A";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected boolean compare(Integer integer) {
		return integer != 0;
	}

}
