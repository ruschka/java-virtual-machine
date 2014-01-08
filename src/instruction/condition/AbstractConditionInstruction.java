package instruction.condition;

import enviroment.Frame;
import enviroment.Heap;
import instruction.AbstractInstruction;

public abstract class AbstractConditionInstruction extends AbstractInstruction {

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		short offset = getShortFromNextTwoBytes(bytecode, bytecodeIndex);
		if (evaluateCondition(frame)) {
			return bytecodeIndex + offset;
		}
		return getBytecodeIndex(bytecodeIndex);
	}
	
	protected abstract boolean evaluateCondition(Frame frame);
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 3;
	}

}
