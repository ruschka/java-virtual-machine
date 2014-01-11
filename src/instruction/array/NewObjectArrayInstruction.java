package instruction.array;

import object.ArrayObject;
import object.IntegerObject;
import object.Reference;
import enviroment.Frame;
import enviroment.Heap;
import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;

public class NewObjectArrayInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "BD";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		// TODO dalsi dva byty jsou typ (index do constant poolu), ktery urcuje typ pole. mel by se ulozit do objektu pole pro dalsi kontroly.
		Reference lenghtReference = frame.pop();
		Integer lenght = ((IntegerObject)lenghtReference.getObject()).getValue();
		ArrayObject array = new ArrayObject(lenght);
		heap.addObject(array);
		frame.push(array);
		return getBytecodeIndex(bytecodeIndex);
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 3;
	}

}
