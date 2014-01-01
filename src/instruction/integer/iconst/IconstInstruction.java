package instruction.integer.iconst;

import object.IntegerObject;
import enviroment.Frame;
import enviroment.Heap;
import instruction.AbstractInstruction;

public abstract class IconstInstruction extends AbstractInstruction {

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		IntegerObject object = new IntegerObject(getValue(bytecode, bytecodeIndex));
		heap.addObject(object);
		frame.push(object);
		return getBytecodeIndex(bytecodeIndex);
	}
	
	protected abstract Integer getValue(byte[] bytecode, int bytecodeIndex);

}
