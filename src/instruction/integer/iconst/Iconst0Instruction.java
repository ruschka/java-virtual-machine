package instruction.integer.iconst;

import instruction.AbstractInstruction;
import object.IntegerObject;
import enviroment.Frame;
import enviroment.Heap;

/**
 * instrukce iconst_0
 * @author ruschka
 *
 */
public class Iconst0Instruction extends AbstractInstruction {
	
	public static final String OPCODE = "03";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		IntegerObject object = new IntegerObject(0);
		heap.addObject(object);
		frame.push(object);
		return getBytecodeIndex(bytecodeIndex);
	}

}
