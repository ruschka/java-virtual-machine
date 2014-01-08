package instruction.object;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import instruction.AbstractInstruction;
import object.Reference;
import object.SimulatedFileReader;
import object.SimulatedObject;

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
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		FieldOrMethodInfo methodInfo = getFieldOrMethodInfo(frame, bytecode, bytecodeIndex);
		MethodSignatureInfo signatureInfo = getMethodSignatureInfo(methodInfo.signature);
		
		if (isSimulated(methodInfo.className)) {
			return simulatedInvoke(frame, heap, bytecode, bytecodeIndex, methodInfo, signatureInfo);
		} else {
			return standardInvoke(frame, heap, bytecode, bytecodeIndex, methodInfo, signatureInfo);
		}
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 3;
	}
	
	private int standardInvoke(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, FieldOrMethodInfo methodInfo, MethodSignatureInfo signatureInfo) {
		// tridu musime ziskat staticky (tak jak byla urcena pri kompilaci)
		JavaClass clazz = ClassLoader.loadClass(methodInfo.className);
		Method method = ClassLoader.getMethodByName(clazz, methodInfo.name, methodInfo.signature);
		
		Frame newFrame = new Frame(frame, clazz.getConstantPool(), method.getCode().getMaxLocals());
		// argumenty metody
		for (int i = signatureInfo.argumentCount; i > 0; i--) {
			newFrame.setLocal(i, frame.pop().getObject());
		}
		// reference na this
		Reference objectReference = frame.pop();
		checkJavaObject(objectReference);
		newFrame.setLocal(Frame.THIS, objectReference.getObject());
		// spusteni metody
		MethodRunner methodRunner = new MethodRunner(method, newFrame, heap);
		methodRunner.run();
		return getBytecodeIndex(bytecodeIndex);
	}
	
	private int simulatedInvoke(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, FieldOrMethodInfo methodInfo, MethodSignatureInfo signatureInfo) {
		LinkedList<Reference> arguments = getArguments(frame, signatureInfo);
		Reference objectReference = frame.pop();
		checkSimulatedObject(objectReference);
		SimulatedObject<?> object = (SimulatedObject<?>) objectReference.getObject();
		
		return getBytecodeIndex(bytecodeIndex);
	}

}
