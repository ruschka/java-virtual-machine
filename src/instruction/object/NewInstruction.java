package instruction.object;

import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;
import object.AbstractObject;
import object.JavaObject;
import object.SimulatedFileReader;
import object.SimulatedFileWriter;

import org.apache.bcel.classfile.Constant;
import org.apache.bcel.classfile.ConstantClass;
import org.apache.bcel.classfile.ConstantUtf8;
import org.apache.bcel.classfile.JavaClass;

import enviroment.ClassLoader;
import enviroment.Frame;
import enviroment.Heap;

public class NewInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "BB";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		int index = getIntegerFromNextTwoBytes(bytecode, bytecodeIndex);
		Constant constant = frame.getConstant(index);
		int nameIndex = ((ConstantClass)constant).getNameIndex();
		Constant nameConstant = frame.getConstant(nameIndex);
		String className = ((ConstantUtf8)nameConstant).getBytes();
		AbstractObject object = null;
		if (isSimulated(className)) {
			// TODO upravit bez if
			if (SimulatedFileReader.CLASS_NAME.equals(className)) {
				object = new SimulatedFileReader();
			} else if (SimulatedFileWriter.CLASS_NAME.equals(className)) {
				object = new SimulatedFileWriter();
			}
		} else {
			JavaClass loadedClass = ClassLoader.loadClass(className);
			object = new JavaObject(loadedClass);
		}
		if (object == null) {
			throw new IllegalStateException("Object cannot be null.");
		}
		heap.addObject(object);
		frame.push(object);
		return getBytecodeIndex(bytecodeIndex);
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 3;
	}

}
