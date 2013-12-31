package instruction.condition;

/**
 * ifgt succeeds if and only if value > 0
 * @author ruschka
 *
 */
public class IfgtCondition extends IfInstruction {
	
	public static final String OPCODE = "9D";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected boolean compare(Integer integer) {
		return integer > 0;
	}

}
