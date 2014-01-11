package instruction.returns;

import enviroment.Frame;
import enviroment.Heap;
import garbagecollector.IGarbageCollector;

public class ReturnInstruction extends AbstractReturnInstruction {
	
	public static final String OPCODE = "B1";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		return getBytecodeIndex(bytecodeIndex);
	}

}
