package instruction.returns;

import instruction.AbstractInstruction;

public abstract class AbstractReturnInstruction extends AbstractInstruction {
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return Integer.MAX_VALUE;
	}

}
