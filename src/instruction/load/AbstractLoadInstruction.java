package instruction.load;

import object.Reference;
import enviroment.Frame;
import enviroment.Heap;
import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;

public abstract class AbstractLoadInstruction extends AbstractInstruction {

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		Reference reference = frame.getLocal(getLoadIndex(bytecode, bytecodeIndex));
		checkType(reference);
		frame.push(reference.getObject());
		return getBytecodeIndex(bytecodeIndex);
	}
	
	protected abstract int getLoadIndex(byte[] bytecode, int bytecodeIndex);
	
	protected abstract void checkType(Reference reference);

}
