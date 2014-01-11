package instruction.array.load;

import object.ArrayObject;
import object.IntegerObject;
import object.Reference;
import enviroment.Frame;
import enviroment.Heap;
import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;

public abstract class AbstractArrayLoadInstruction extends AbstractInstruction {

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		Reference indexReference = frame.pop();
		Reference arrayReference = frame.pop();
		checkInteger(indexReference);
		checkArrayObject(arrayReference);
		IntegerObject index = (IntegerObject) indexReference.getObject();
		ArrayObject array = (ArrayObject) arrayReference.getObject();
		Reference valueReference = array.getValue(index.getValue());
		checkValue(valueReference);
		frame.push(valueReference.getObject());
		return getBytecodeIndex(bytecodeIndex);
	}
	
	protected abstract void checkValue(Reference valueReference);

}
