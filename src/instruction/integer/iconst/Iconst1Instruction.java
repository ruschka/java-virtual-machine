package instruction.integer.iconst;

import instruction.AbstractInstruction;
import object.IntegerObject;
import object.Reference;
import enviroment.Frame;
import enviroment.Heap;

/**
 * instrukce iconst_1
 * @author ruschka
 *
 */
public class Iconst1Instruction extends AbstractInstruction {
	
	public static final String OPCODE = "04";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		IntegerObject object = new IntegerObject(1);
		heap.addObject(object);
		frame.push(new Reference(object));
		return bytecodeIndex;
	}

}
