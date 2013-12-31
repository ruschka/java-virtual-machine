package instruction.object;

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
public class InvokeSpecialInstruction extends InvokeMethodInstruction {
	
	public static final String OPCODE = "B7";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		MethodInfo methodInfo = getMethodInfo(frame, bytecode, bytecodeIndex);
		SignatureInfo signatureInfo = getSignatureInfo(methodInfo.methodSignature);
		
		// tridu musime ziskat staticky (tak jak byla urcena pri kompilaci)
		JavaClass clazz = ClassLoader.loadClass(methodInfo.className);
		Method method = ClassLoader.getMethodByName(clazz, methodInfo.methodName);
		
		Frame newFrame = new Frame(frame, clazz.getConstantPool(), method.getCode().getMaxLocals());
		// argumenty metody
		for (int i = signatureInfo.argumentCount; i > 0; i--) {
			newFrame.setLocal(i, frame.pop());
		}
		// reference na this
		Reference object = frame.pop();
		checkObject(object);
		newFrame.setLocal(Frame.THIS, object);
		// spusteni metody
		MethodRunner methodRunner = new MethodRunner(method, newFrame, heap);
		methodRunner.run();
		
		return getBytecodeIndex(bytecodeIndex);
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 2;
	}

}
