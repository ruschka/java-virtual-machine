package instruction.util;

import instruction.AbstractInstruction;
import object.IntegerObject;
import object.SimulatedString;

import org.apache.bcel.classfile.Constant;
import org.apache.bcel.classfile.ConstantInteger;
import org.apache.bcel.classfile.ConstantString;
import org.apache.bcel.classfile.ConstantUtf8;

import enviroment.Frame;
import enviroment.Heap;

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
			SimulatedString stringObject = new SimulatedString(string);
			heap.addObject(stringObject);
			frame.push(stringObject);
		} else if (constant instanceof ConstantInteger) {
			int value = ((ConstantInteger)constant).getBytes();
			IntegerObject integerObject = new IntegerObject(value);
			heap.addObject(integerObject);
			frame.push(integerObject);
		} else {
			// TODO dopsat pro konstanty typu float
			throw new UnsupportedOperationException("TODO Konstanta constant poolu na zasobnik.");
		}
		return getBytecodeIndex(bytecodeIndex);
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 2;
	}

}
