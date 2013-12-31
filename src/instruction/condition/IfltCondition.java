package instruction.condition;

/**
 * iflt succeeds if and only if value < 0
 * @author ruschka
 *
 */
public class IfltCondition extends IfInstruction {
	
	public static final String OPCODE = "9B";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected boolean compare(Integer integer) {
		return integer < 0;
	}

}
