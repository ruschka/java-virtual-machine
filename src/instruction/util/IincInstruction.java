package instruction.util;

import object.IntegerObject;
import object.Reference;
import enviroment.Frame;
import enviroment.Heap;
import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;

public class IincInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "84";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		int index = getIntegerFromNextByte(bytecode, bytecodeIndex);
		int value = getByteFromNextByte(bytecode, bytecodeIndex + 1);
		Reference localReference = frame.getLocal(index);
		int local = ((IntegerObject)localReference.getObject()).getValue();
		IntegerObject newLocal = new IntegerObject(local + value);
		heap.addObject(newLocal);
		frame.setLocal(index, newLocal);
		return getBytecodeIndex(bytecodeIndex);
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 3;
	}

}
