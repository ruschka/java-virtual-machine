package instruction.integer.iconst;


/**
 * instrukce iconst_3
 * @author ruschka
 *
 */
public class Iconst3Instruction extends IconstInstruction {
	
	public static final String OPCODE = "06";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected Integer getValue(byte[] bytecode, int bytecodeIndex) {
		return 3;
	}

}
