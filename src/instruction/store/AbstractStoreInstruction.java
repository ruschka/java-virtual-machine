package instruction.store;

import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;
import object.Reference;
import enviroment.Frame;
import enviroment.Heap;

public abstract class AbstractStoreInstruction extends AbstractInstruction {

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		Reference reference = frame.pop();
		checkType(reference);
		frame.setLocal(getStoreIndex(bytecode, bytecodeIndex), reference.getObject());
		return getBytecodeIndex(bytecodeIndex);
	}
	
	protected abstract int getStoreIndex(byte[] bytecode, int bytecodeIndex);
	
	protected abstract void checkType(Reference reference);

}
