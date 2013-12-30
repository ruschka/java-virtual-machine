package instruction.integer.istore;

import object.Heap;
import object.Reference;
import enviroment.Frame;
import instruction.AbstractInstruction;

public abstract class AbstractIstoreInstruction extends AbstractInstruction {

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		Reference reference = frame.pop();
		checkInteger(reference);
		frame.setLocal(getStoreIndex(bytecode, bytecodeIndex), reference);
		return getBytecodeIndex(bytecodeIndex);
	}
	
	protected abstract int getStoreIndex(byte[] bytecode, int bytecodeIndex);

}
