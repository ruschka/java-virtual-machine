package instruction.integer.iconst;

import instruction.AbstractInstruction;
import object.Heap;
import object.IntegerObject;
import object.Reference;
import enviroment.Frame;

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
		frame.push(new Reference(object));
		return bytecodeIndex;
	}

}
