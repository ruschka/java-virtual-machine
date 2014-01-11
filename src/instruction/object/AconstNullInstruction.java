package instruction.object;

import object.AbstractObject;
import enviroment.Frame;
import enviroment.Heap;
import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;

public class AconstNullInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "01";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		frame.push(AbstractObject.NULL);
		return getBytecodeIndex(bytecodeIndex);
	}

}
