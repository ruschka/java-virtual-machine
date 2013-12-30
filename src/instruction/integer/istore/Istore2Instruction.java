package instruction.integer.istore;

import instruction.AbstractInstruction;
import object.Heap;
import object.Reference;
import enviroment.Frame;

public class Istore2Instruction extends AbstractInstruction {
	
	public static final String OPCODE = "3D";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		Reference reference = frame.pop();
		checkInteger(reference);
		frame.setLocal(2, reference);
		return bytecodeIndex;
	}

}
