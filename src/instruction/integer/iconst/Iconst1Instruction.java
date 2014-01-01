package instruction.integer.iconst;


/**
 * instrukce iconst_1
 * @author ruschka
 *
 */
public class Iconst1Instruction extends IconstInstruction {
	
	public static final String OPCODE = "04";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected Integer getValue(byte[] bytecode, int bytecodeIndex) {
		return 1;
	}

}
