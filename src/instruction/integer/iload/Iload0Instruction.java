package instruction.integer.iload;

import instruction.AbstractInstruction;
import object.Reference;
import enviroment.Frame;
import enviroment.Heap;

public class Iload0Instruction extends AbstractInstruction {
	
	public static final String OPCODE = "1A";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		Reference reference = frame.getLocal(0);
		checkInteger(reference);
		frame.push(reference);
		return bytecodeIndex;
	}

}
