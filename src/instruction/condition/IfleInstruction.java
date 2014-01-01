package instruction.condition;

/**
 * ifle succeeds if and only if value <= 0
 * @author ruschka
 *
 */
public class IfleInstruction extends IfInstruction {
	
	public static final String OPCODE = "9E";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected boolean compare(Integer integer) {
		return integer <= 0;
	}

}
