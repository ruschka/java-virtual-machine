package instruction.integer.iconst;


/**
 * instrukce iconst_m1
 * @author ruschka
 *
 */
public class Iconstm1Instruction extends IconstInstruction {
	
	public static final String OPCODE = "02";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected Integer getValue(byte[] bytecode, int bytecodeIndex) {
		return -1;
	}

}
