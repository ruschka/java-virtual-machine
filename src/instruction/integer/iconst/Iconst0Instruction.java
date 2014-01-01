package instruction.integer.iconst;


/**
 * instrukce iconst_0
 * @author ruschka
 *
 */
public class Iconst0Instruction extends IconstInstruction {
	
	public static final String OPCODE = "03";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected Integer getValue(byte[] bytecode, int bytecodeIndex) {
		return 0;
	}

}
