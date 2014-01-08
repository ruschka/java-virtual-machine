package instruction;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import object.ArrayObject;
import object.ClassObject;
import object.ComplexObject;
import object.IntegerObject;
import object.JavaObject;
import object.Reference;
import object.SimulatedFileReader;
import object.SimulatedFileWriter;
import object.SimulatedObject;

import org.apache.bcel.classfile.ConstantCP;
import org.apache.bcel.classfile.ConstantClass;
import org.apache.bcel.classfile.ConstantNameAndType;
import org.apache.bcel.classfile.ConstantUtf8;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

import enviroment.ClassLoader;
import enviroment.Frame;
import enviroment.Heap;
import enviroment.MethodRunner;

public abstract class AbstractInstruction {
	
	private static final Set<String> SIMULATED_CLASSES = new HashSet<String>();
	
	static {
		SIMULATED_CLASSES.add(SimulatedFileReader.CLASS_NAME);
		SIMULATED_CLASSES.add(SimulatedFileWriter.CLASS_NAME);
	}
	
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
	
	protected boolean isSimulated(String className) {
		return SIMULATED_CLASSES.contains(className);
	}
	
	/**
	 * Default posunuti indexu ukazujiciho na aktualni pozici v bytecodu.
	 * Kazda instrukce muze posunuti predefinovat (a take se to casto deje).
	 * 
	 * Spravnou definici teto metody je instrukce zodpovedna za to,
	 * aby po jejim vykonani byl bytecodeIndex nastaveny na dalsi instrukci.
	 * @param bytecodeIndex Index, na kterem lezi aktualni instrukce.
	 * @return Index, na kterem lezi dalsi instrukce.
	 */
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 1;
	}
	
	/**
	 * Z nasledujiciho bytu (oproti bytecodeIndexu) v bytecodu vyrobi int.
	 * @param bytecode
	 * @param bytecodeIndex
	 * @return
	 */
	protected int getIntegerFormNextByte(byte[] bytecode, int bytecodeIndex) {
		return ((int)bytecode[bytecodeIndex + 1]) & 0xFF;
	}
	
	/**
	 * Z nasledujiciho dvou bytu (oproti bytecodeIndexu) v bytecodu vyrobi int.
	 * @param bytecode
	 * @param bytecodeIndex
	 * @return
	 */
	protected int getIntegerFromNextTwoBytes(byte[] bytecode, int bytecodeIndex) {
		int b1 = (((int)bytecode[bytecodeIndex + 1]) & 0xFF) << 8;
		int b2 = ((int)bytecode[bytecodeIndex + 2]) & 0xFF;
		return b1 | b2;
	}
	
	protected short getShortFromNextTwoBytes(byte[] bytecode, int bytecodeIndex) {
		return (short) getIntegerFromNextTwoBytes(bytecode, bytecodeIndex);
	}
	
	protected void checkInteger(Reference reference) {
		if (!(reference.getObject() instanceof IntegerObject)) {
			throw new IllegalStateException("Object has to be integer.");
		}
	}
	
	protected void checkComplexObject(Reference reference) {
		if (!(reference.getObject() instanceof ComplexObject) && !(reference.getObject() instanceof SimulatedObject)) {
			throw new IllegalStateException("Object has to be complex object.");
		}
	}
	
	protected void checkJavaObject(Reference reference) {
		if (!(reference.getObject() instanceof JavaObject)) {
			throw new IllegalStateException("Object has to be java object.");
		}
	}
	
	protected void checkArrayObject(Reference reference) {
		if (!(reference.getObject() instanceof ArrayObject)) {
			throw new IllegalStateException("Object has to be array object.");
		}
	}
	
	protected void checkSimulatedObject(Reference reference) {
		if (!(reference.getObject() instanceof SimulatedObject)) {
			throw new IllegalStateException("Object has to be simulated object.");
		}
	}
	
	protected void checkInitialized(ClassObject object, String className, Heap heap) {
		if (!object.isInitialized()) {
			object.initialize();
			JavaClass javaClass = ClassLoader.loadClass(className);
			Method method = ClassLoader.getMethodByName(javaClass, "<clinit>", "()V");
			Frame frame = new Frame(null, javaClass.getConstantPool(), method.getCode().getMaxLocals());
			MethodRunner runner = new MethodRunner(method, frame, heap);
			runner.run();
		}
	}
	
	protected LinkedList<Reference> getArguments(Frame frame, MethodSignatureInfo info) {
		LinkedList<Reference> arguments = new LinkedList<Reference>();
		for (int i = 0; i < info.argumentCount; i++) {
			arguments.add(frame.pop());
		}
		return arguments;
	}
	
	protected int simulatedInvoke(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, FieldOrMethodInfo methodInfo, MethodSignatureInfo signatureInfo) {
		LinkedList<Reference> arguments = getArguments(frame, signatureInfo);
		Reference objectReference = frame.pop();
		checkSimulatedObject(objectReference);
		SimulatedObject<?> object = (SimulatedObject<?>) objectReference.getObject();
		object.simulateMethod(frame, heap, methodInfo, arguments);
		return getBytecodeIndex(bytecodeIndex);
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
		int argumentStart = signature.indexOf('(');
		if (argumentStart != 0) {
			throw new IllegalStateException("ArgumentStart has to be 0");
		}
		int argumentEnd = signature.indexOf(')');
		if (argumentEnd < 1) {
			throw new IllegalStateException("ArgumentStart has to be higher than 0");
		}
		String arguments = signature.substring(argumentStart + 1, argumentEnd);
		info.argumentCount = getArgumentCount(arguments);
		return info;
	}
	
	/**
	 * http://stackoverflow.com/a/9909370/2913412
	 * @param arguments Retezec definujici argumenty
	 * @return pocet argumentu
	 */
	private int getArgumentCount(String arguments) {
		int argumentCount = 0;
		int index = 0;
		boolean increment = true;
		while (index < arguments.length()) {
			char ch = arguments.charAt(index);
			if (ch == '[') { // pole
				increment = false;
			}
			if (ch == 'L') { // trida
				index = arguments.indexOf(';', index); // posuneme se na konec nazvu tridy
			}
			++index; // index posuneme
			if (increment) {  // pokud na aktualnim indexu nebylo pole, zvysime pocet argumentu
				++argumentCount;
			}
			increment = true;
		}
		return argumentCount;
	}
	
	public class FieldOrMethodInfo {
		
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
	
	public class MethodSignatureInfo {
		
		/**
		 * pocet argumentu metody
		 */
		public int argumentCount;
		
	}

}
