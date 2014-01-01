package instruction.integer.iconst;


/**
 * instrukce iconst_2
 * @author ruschka
 *
 */
public class Iconst2Instruction extends IconstInstruction {
	
	public static final String OPCODE = "05";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected Integer getValue(byte[] bytecode, int bytecodeIndex) {
		return 2;
	}

}
