package instruction.util;

import enviroment.Frame;
import enviroment.Heap;
import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;

public class PopInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "57";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		frame.pop();
		return getBytecodeIndex(bytecodeIndex);
	}

}
