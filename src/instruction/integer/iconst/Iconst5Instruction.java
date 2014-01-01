package instruction.integer.iconst;


/**
 * instrukce iconst_5
 * @author ruschka
 *
 */
public class Iconst5Instruction extends IconstInstruction {

	public static final String OPCODE = "08";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected Integer getValue(byte[] bytecode, int bytecodeIndex) {
		return 5;
	}

}
