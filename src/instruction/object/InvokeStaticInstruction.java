package instruction.object;

import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;

import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;

import enviroment.ClassLoader;
import enviroment.Frame;
import enviroment.Heap;
import enviroment.MethodRunner;

public class InvokeStaticInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "B8";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		FieldOrMethodInfo methodInfo = getFieldOrMethodInfo(frame, bytecode, bytecodeIndex);
		MethodSignatureInfo signatureInfo = getMethodSignatureInfo(methodInfo.signature);
		
		JavaClass clazz = ClassLoader.loadClass(methodInfo.className);
		Method method = ClassLoader.getMethodByName(clazz, methodInfo.name, methodInfo.signature);
		
		Frame newFrame = new Frame(frame, method.getConstantPool(), method.getCode().getMaxLocals());
		// argumenty metody
		for (int i = signatureInfo.argumentCount - 1; i >= 0; i--) {
			newFrame.setLocal(i, frame.pop().getObject());
		}
		// spusteni metody
		MethodRunner methodRunner = new MethodRunner(method, newFrame, heap, garbageCollector);
		methodRunner.run();
		
		return getBytecodeIndex(bytecodeIndex);
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 3;
	}

}
