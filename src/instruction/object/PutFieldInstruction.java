package instruction.object;

import instruction.AbstractInstruction;
import object.JavaObject;
import object.Reference;
import enviroment.Frame;
import enviroment.Heap;

public class PutFieldInstruction extends AbstractInstruction {
	
	public static final String OPCODE = "B5";

	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	public int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex) {
		FieldOrMethodInfo fieldInfo = getFieldOrMethodInfo(frame, bytecode, bytecodeIndex);
		Reference valueRefence = frame.pop();
		Reference objectRefence = frame.pop();
		
		checkJavaObject(objectRefence);
		// TODO dodelat kontrolu typu
		
		JavaObject object = (JavaObject) objectRefence.getObject();
		object.putField(fieldInfo.name, valueRefence.getObject());
		
		return getBytecodeIndex(bytecodeIndex);
	}
	
	@Override
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex + 3;
	}

}
