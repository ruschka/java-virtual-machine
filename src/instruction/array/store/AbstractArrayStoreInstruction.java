package instruction.array.store;

import instruction.AbstractInstruction;
import object.ArrayObject;
import object.IntegerObject;
import object.Reference;
import enviroment.Frame;
import enviroment.Heap;

public abstract class AbstractArrayStoreInstruction extends AbstractInstruction {

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		Reference valueReference = frame.pop();
		Reference indexReference = frame.pop();
		Reference arrayReference = frame.pop();
		checkValueType(valueReference);
		checkInteger(indexReference);
		checkArrayObject(arrayReference);
		IntegerObject index = (IntegerObject) indexReference.getObject();
		ArrayObject array = (ArrayObject) arrayReference.getObject();
		array.putValue(index.getValue(), valueReference.getObject());
		return getBytecodeIndex(bytecodeIndex);
	}
	
	protected abstract void checkValueType(Reference valueReference);

}
