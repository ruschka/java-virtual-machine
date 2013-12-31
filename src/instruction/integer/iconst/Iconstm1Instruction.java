package instruction.integer.iconst;

import instruction.AbstractInstruction;
import object.IntegerObject;
import enviroment.Frame;
import enviroment.Heap;

/**
 * instrukce iconst_m1
 * @author ruschka
 *
 */
public class Iconstm1Instruction extends AbstractInstruction {
	
	public static final String OPCODE = "02";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		IntegerObject object = new IntegerObject(-1);
		heap.addObject(object);
		frame.push(object);
		return getBytecodeIndex(bytecodeIndex);
	}

}
