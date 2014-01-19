package instruction.object;

import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;

import java.util.LinkedList;

import object.JavaObject;
import object.Reference;

import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

import enviroment.ClassLoader;
import enviroment.Frame;
import enviroment.Heap;
import enviroment.MethodRunner;


public class InvokeVirtualInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "B6";

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
		// musime uchovat argumenty
		LinkedList<Reference> arguments = getArguments(frame, signatureInfo);
		
		// metodu musime ziskat dynamicky z pushnuteho objektu
		Reference objectReference = frame.pop();
		checkJavaObject(objectReference);
		JavaClass clazz = ((JavaObject)objectReference.getObject()).getJavaClass();
		Method method = ClassLoader.getMethodByName(clazz, methodInfo.name, methodInfo.signature);
		
		// pripravime novy frame
		Frame newFrame = new Frame(frame, method.getConstantPool(), method.getCode().getMaxLocals());
		for (int i = signatureInfo.argumentCount; i > 0; i--) {
			newFrame.setLocal(i, arguments.removeFirst().getObject());
		}
		newFrame.setLocal(Frame.THIS, objectReference.getObject());
		
		// spusteni metody
		MethodRunner methodRunner = new MethodRunner(method, newFrame, heap, garbageCollector);
		methodRunner.run();
		
		return getBytecodeIndex(bytecodeIndex);
	}

}
