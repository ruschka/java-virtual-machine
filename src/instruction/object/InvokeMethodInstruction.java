package instruction.object;

import org.apache.bcel.classfile.ConstantClass;
import org.apache.bcel.classfile.ConstantMethodref;
import org.apache.bcel.classfile.ConstantNameAndType;
import org.apache.bcel.classfile.ConstantUtf8;

import enviroment.Frame;
import instruction.AbstractInstruction;

public abstract class InvokeMethodInstruction extends AbstractInstruction {
	
	protected MethodInfo getMethodInfo(Frame frame, byte[] bytecode, int bytecodeIndex) {
		MethodInfo info = new MethodInfo();
		
		int index = getIntegerFromNextTwoBytes(bytecode, bytecodeIndex);
		// konstanta metody. obsahuje referenci na tridu a na metodu 
		ConstantMethodref methodrefConstant = (ConstantMethodref) frame.getConstant(index);
		
		// metoda
		int nameAndTypeIndex = methodrefConstant.getNameAndTypeIndex();
		// konstanta se jmenem a typem metody
		ConstantNameAndType nameAndTypeConstant = (ConstantNameAndType) frame.getConstant(nameAndTypeIndex);
		int methodNameIndex = nameAndTypeConstant.getNameIndex();
		// konstanta se jmenem metody
		ConstantUtf8 methodNameConstant = (ConstantUtf8) frame.getConstant(methodNameIndex);
		info.methodName = methodNameConstant.getBytes();
		int signatureIndex = nameAndTypeConstant.getSignatureIndex();
		// konstanta se signaturou metody
		ConstantUtf8 signatureConstant = (ConstantUtf8) frame.getConstant(signatureIndex);
		info.methodSignature = signatureConstant.getBytes();
		
		// trida
		int classIndex = methodrefConstant.getClassIndex();
		// konstanta tridy
		ConstantClass classConstant = (ConstantClass) frame.getConstant(classIndex);
		int classNameIndex = classConstant.getNameIndex();
		// konstanta se jmenem tridy
		ConstantUtf8 classNameConstant = (ConstantUtf8) frame.getConstant(classNameIndex);
		info.className = classNameConstant.getBytes();
		
		return info;
	}
	
	protected SignatureInfo getSignatureInfo(String signature) {
		SignatureInfo info = new SignatureInfo();
		// TODO predelat lepe. zatim umi jen zakladni typy
		int argumentsStart = signature.indexOf('(');
		if (argumentsStart != 0) {
			throw new IllegalStateException("ArgumentsStart has to be 0");
		}
		int argumentsEnd = signature.indexOf(')');
		if (argumentsEnd < 1) {
			throw new IllegalStateException("ArgumentsStart has to be higher than 0");
		}
		info.argumentCount = argumentsEnd - argumentsStart - 1;
		return info;
	}
	
	protected class MethodInfo {
		
		public String className;
		public String methodName;
		public String methodSignature;
		
	}
	
	protected class SignatureInfo {
		
		public int argumentCount;
		
	}

}
