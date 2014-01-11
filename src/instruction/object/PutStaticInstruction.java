package instruction.object;

import garbagecollector.IGarbageCollector;
import instruction.AbstractInstruction;
import object.ClassObject;
import object.Reference;
import enviroment.ClassLoader;
import enviroment.Frame;
import enviroment.Heap;

public class PutStaticInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "B3";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex, IGarbageCollector garbageCollector) {
		FieldOrMethodInfo info = getFieldOrMethodInfo(frame, bytecode, bytecodeIndex);
		Reference classObjectReference = ClassLoader.getClassObject(info.className, heap);
		ClassObject classObject = (ClassObject) classObjectReference.getObject();
		
		checkInitialized(classObject, info.className, heap, garbageCollector);
		
		classObject.putField(info.name, frame.pop().getObject());
		return getBytecodeIndex(bytecodeIndex);
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 3;
	}

}
