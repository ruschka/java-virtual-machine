package instruction.condition;

import object.IntegerObject;
import object.Reference;
import enviroment.Frame;

/**
 * http://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.if_icmp_cond
 * 
 * if_icmple succeeds if and only if value1 <= value2
 * @author ruschka
 *
 */
public class IfIcmpleInstruction extends AbstractConditionInstruction {
	
	public static final String OPCODE = "A4";
	
	@Override
	public String getOpcode() {
		return OPCODE;
	}

	@Override
	protected boolean evaluateCondition(Frame frame) {
		Reference reference2 = frame.pop();
		Reference reference1 = frame.pop();
		checkInteger(reference1);
		checkInteger(reference2);
		Integer integer1 = ((IntegerObject)reference1.getObject()).getValue();
		Integer integer2 = ((IntegerObject)reference2.getObject()).getValue();
		return integer1 <= integer2;
	}

}
