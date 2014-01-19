package instruction.object;

import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;
import object.Reference;

import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

import enviroment.ClassLoader;
import enviroment.Frame;
import enviroment.Heap;
import enviroment.MethodRunner;

/**
 * Vola se napriklad pri zakladani nove tridy (metoda init).
 * @author ruschka
 *
 */
public class InvokeSpecialInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "B7";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		FieldOrMethodInfo methodInfo = getFieldOrMethodInfo(frame, bytecode, bytecodeIndex);
		MethodSignatureInfo signatureInfo = getMethodSignatureInfo(methodInfo.signature);
		
		if (isSimulated(methodInfo.className)) {
			return simulatedInvoke(frame, heap, bytecode, bytecodeIndex, methodInfo, signatureInfo);
		} else {
			return standardInvoke(frame, heap, bytecode, bytecodeIndex, methodInfo, signatureInfo, garbageCollector);
		}
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 3;
	}
	
	private int standardInvoke(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, FieldOrMethodInfo methodInfo, MethodSignatureInfo signatureInfo, IGarbageCollector garbageCollector) {
		// tridu musime ziskat staticky (tak jak byla urcena pri kompilaci)
		JavaClass clazz = ClassLoader.loadClass(methodInfo.className);
		Method method = ClassLoader.getMethodByName(clazz, methodInfo.name, methodInfo.signature);
		
		Frame newFrame = new Frame(frame, method.getConstantPool(), method.getCode().getMaxLocals());
		// argumenty metody
		for (int i = signatureInfo.argumentCount; i > 0; i--) {
			newFrame.setLocal(i, frame.pop().getObject());
		}
		// reference na this
		Reference objectReference = frame.pop();
		checkJavaObject(objectReference);
		newFrame.setLocal(Frame.THIS, objectReference.getObject());
		// spusteni metody
		MethodRunner methodRunner = new MethodRunner(method, newFrame, heap, garbageCollector);
		methodRunner.run();
		return getBytecodeIndex(bytecodeIndex);
	}

}
