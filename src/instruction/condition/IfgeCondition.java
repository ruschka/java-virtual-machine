package instruction.condition;

/**
 * ifge succeeds if and only if value >= 0
 * @author ruschka
 *
 */
public class IfgeCondition extends IfInstruction {
	
	public static final String OPCODE = "9C";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected boolean compare(Integer integer) {
		return integer >= 0;
	}

}
