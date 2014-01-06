package instruction.util;

import org.apache.bcel.classfile.Constant;
import org.apache.bcel.classfile.ConstantString;
import org.apache.bcel.classfile.ConstantUtf8;

import enviroment.Frame;
import enviroment.Heap;
import instruction.AbstractInstruction;

public class LdcInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "12";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		int index = getIntegerFormNextByte(bytecode, bytecodeIndex);
		Constant constant = frame.getConstant(index);
		if (constant instanceof ConstantString) {
			int stringIndex = ((ConstantString)constant).getStringIndex();
			ConstantUtf8 stringConstant = (ConstantUtf8) frame.getConstant(stringIndex);
			String string = stringConstant.getBytes();
			// TODO dopsat - musi se poslat na zasobnik
		}
		// TODO dopsat pro konstanty typu int a float
		return getBytecodeIndex(bytecodeIndex);
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 2;
	}

}
