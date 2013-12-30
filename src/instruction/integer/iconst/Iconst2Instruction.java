package instruction.integer.iconst;

import instruction.AbstractInstruction;
import object.IntegerObject;
import object.Reference;
import enviroment.Frame;
import enviroment.Heap;

/**
 * instrukce iconst_2
 * @author ruschka
 *
 */
public class Iconst2Instruction extends AbstractInstruction {
	
	public static final String OPCODE = "05";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		IntegerObject object = new IntegerObject(2);
		heap.addObject(object);
		frame.push(new Reference(object));
		return bytecodeIndex;
	}

}
