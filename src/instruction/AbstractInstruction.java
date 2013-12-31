package instruction;

import object.IntegerObject;
import object.JavaObject;
import object.Reference;

import org.apache.bcel.classfile.ConstantCP;
import org.apache.bcel.classfile.ConstantClass;
import org.apache.bcel.classfile.ConstantNameAndType;
import org.apache.bcel.classfile.ConstantUtf8;

import enviroment.Frame;
import enviroment.Heap;

public abstract class AbstractInstruction {
	
	public abstract String getOpcode();
	
	/**
	 * Provede danou instrukci.
	 * @param frame aktualni frame.
	 * @param heap heap
	 * @param bytecode bytecode provadene metody.
	 * @param bytecodeIndex bytecodeIndex pred provedenim instrukce.
	 * @return Vrati aktualni bytecodeIndex po provedeni instrukce.
	 */
	public abstract int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex);
	
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 1;
	}
	
	protected int getIntegerFormNextByte(byte[] bytecode, int bytecodeIndex) {
		return (int)bytecode[bytecodeIndex + 1];
	}
	
	protected int getIntegerFromNextTwoBytes(byte[] bytecode, int bytecodeIndex) {
		return (((int)bytecode[bytecodeIndex + 1]) << 8) + bytecode[bytecodeIndex + 2];
	}
	
	protected void checkInteger(Reference reference) {
		if (!(reference.getObject() instanceof IntegerObject)) {
			throw new IllegalStateException("Object has to be integer.");
		}
	}
	
	protected void checkObject(Reference reference) {
		if (!(reference.getObject() instanceof JavaObject)) {
			throw new IllegalStateException("Object has to be java object.");
		}
	}

	protected FieldOrMethodInfo getFieldOrMethodInfo(Frame frame, byte[] bytecode, int bytecodeIndex) {
		FieldOrMethodInfo info = new FieldOrMethodInfo();
		
		int index = getIntegerFromNextTwoBytes(bytecode, bytecodeIndex);
		// konstanta metody. obsahuje referenci na tridu a na metodu 
		ConstantCP methodrefConstant = (ConstantCP) frame.getConstant(index);
		
		// metoda
		int nameAndTypeIndex = methodrefConstant.getNameAndTypeIndex();
		// konstanta se jmenem a typem metody
		ConstantNameAndType nameAndTypeConstant = (ConstantNameAndType) frame.getConstant(nameAndTypeIndex);
		int methodNameIndex = nameAndTypeConstant.getNameIndex();
		// konstanta se jmenem metody
		ConstantUtf8 methodNameConstant = (ConstantUtf8) frame.getConstant(methodNameIndex);
		info.name = methodNameConstant.getBytes();
		int signatureIndex = nameAndTypeConstant.getSignatureIndex();
		// konstanta se signaturou metody
		ConstantUtf8 signatureConstant = (ConstantUtf8) frame.getConstant(signatureIndex);
		info.signature = signatureConstant.getBytes();
		
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

	protected MethodSignatureInfo getMethodSignatureInfo(String signature) {
		MethodSignatureInfo info = new MethodSignatureInfo();
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
	
	protected class FieldOrMethodInfo {
		
		/**
		 * nazev tridy
		 */
		public String className;
		/**
		 * nazev pole nebo metody
		 */
		public String name;
		/**
		 * signatura pole nebo metody
		 */
		public String signature;
		
	}
	
	protected class MethodSignatureInfo {
		
		/**
		 * pocet argumentu metody
		 */
		public int argumentCount;
		
	}

}
