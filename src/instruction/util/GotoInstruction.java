package instruction.util;

import enviroment.Frame;
import enviroment.Heap;
import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;

public class GotoInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "A7";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		short offset = getShortFromNextTwoBytes(bytecode, bytecodeIndex);
		return bytecodeIndex + offset;
	}

}
