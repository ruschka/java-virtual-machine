package instruction.condition;

/**
 * if_icmple succeeds if and only if value1 == value2
 * @author ruschka
 *
 */
public class IfIcmpeqInstruction extends IfIcmpInstruction {
	
	public static final String OPCODE = "9F";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected boolean compareIntegers(Integer integer1, Integer integer2) {
		return integer1 == integer2;
	}

}
