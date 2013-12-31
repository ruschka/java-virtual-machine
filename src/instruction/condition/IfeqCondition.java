package instruction.condition;

/**
 * ifeq succeeds if and only if value = 0
 * @author ruschka
 *
 */
public class IfeqCondition extends IfInstruction {
	
	public static final String OPCODE = "99";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected boolean compare(Integer integer) {
		return integer == 0;
	}

}
