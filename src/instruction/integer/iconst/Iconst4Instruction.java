package instruction.integer.iconst;


/**
 * instrukce iconst_4
 * @author ruschka
 *
 */
public class Iconst4Instruction extends IconstInstruction {

	public static final String OPCODE = "07";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected Integer getValue(byte[] bytecode, int bytecodeIndex) {
		return 4;
	}
	
}
