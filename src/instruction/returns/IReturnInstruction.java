package instruction.returns;

import object.Reference;
import enviroment.Frame;
import enviroment.Heap;

/**
 * http://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.ireturn
 * @author ruschka
 *
 */
public class IReturnInstruction extends AbstractReturnInstruction {
	
	public static final String OPCODE = "AC";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		Reference reference = frame.pop();
		checkInteger(reference);
		frame.getParent().push(reference.getObject());
		return getBytecodeIndex(bytecodeIndex);
	}

}
