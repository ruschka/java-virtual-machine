package instruction.object;

import object.JavaObject;
import object.Reference;

import org.apache.bcel.classfile.Constant;
import org.apache.bcel.classfile.ConstantClass;
import org.apache.bcel.classfile.ConstantMethodref;
import org.apache.bcel.classfile.ConstantNameAndType;
import org.apache.bcel.classfile.ConstantUtf8;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.Type;

import enviroment.ClassLoader;
import enviroment.Frame;
import enviroment.Heap;
import enviroment.MethodRunner;
import instruction.AbstractInstruction;

public class InvokeSpecialInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "B7";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		int index = getIntegerFromNextTwoBytes(bytecode, bytecodeIndex);
		// konstanta metody. obsahuje referenci na tridu a na metodu 
		ConstantMethodref methodrefConstant = (ConstantMethodref) frame.getConstant(index);
		int nameAndTypeIndex = methodrefConstant.getNameAndTypeIndex();
		// konstanta se jmenem a typem metody
		ConstantNameAndType nameAndTypeConstant = (ConstantNameAndType) frame.getConstant(nameAndTypeIndex);
		int methodNameIndex = nameAndTypeConstant.getNameIndex();
		// konstanta se jmenem metody
		ConstantUtf8 methodNameConstant = (ConstantUtf8) frame.getConstant(methodNameIndex);
		String methodName = methodNameConstant.getBytes();
		int signatureIndex = nameAndTypeConstant.getSignatureIndex();
		// konstanta se signaturou metody
		ConstantUtf8 signatureConstant = (ConstantUtf8) frame.getConstant(signatureIndex);
		String methodSignature = signatureConstant.getBytes();
		
		int classIndex = methodrefConstant.getClassIndex();
		// konstanta tridy
		ConstantClass classConstant = (ConstantClass) frame.getConstant(classIndex);
		int classNameIndex = classConstant.getNameIndex();
		// konstanta se jmenem tridy
		ConstantUtf8 classNameConstant = (ConstantUtf8) frame.getConstant(classNameIndex);
		String className = classNameConstant.getBytes();
		
		JavaClass clazz = ClassLoader.loadClass(className);
		Method method = ClassLoader.getMethodByName(clazz, methodName);
		int argumentCount = method.getArgumentTypes().length;
		
		Frame newFrame = new Frame(frame, clazz.getConstantPool(), method.getCode().getMaxLocals());
		// argumenty metody
		for (int i = argumentCount; i > 0; i--) {
			newFrame.setLocal(i, frame.pop());
		}
		// reference na this
		newFrame.setLocal(Frame.THIS, frame.pop());
		MethodRunner methodRunner = new MethodRunner(method, newFrame, heap);
		methodRunner.run();
		
		return getBytecodeIndex(bytecodeIndex);
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 2;
	}

}
