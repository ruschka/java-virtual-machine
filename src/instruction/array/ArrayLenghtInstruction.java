package instruction.array;

import object.ArrayObject;
import object.IntegerObject;
import object.Reference;
import enviroment.Frame;
import enviroment.Heap;
import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;

public class ArrayLenghtInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "BE";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		Reference arrayReference = frame.pop();
		checkArrayObject(arrayReference);
		ArrayObject array = (ArrayObject) arrayReference.getObject();
		int length = array.getLength();
		frame.push(new IntegerObject(length));
		return getBytecodeIndex(bytecodeIndex);
	}

}
