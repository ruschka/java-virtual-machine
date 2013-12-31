package instruction.condition;

import object.IntegerObject;
import object.Reference;
import enviroment.Frame;

/**
 * http://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.if_icmp_cond
 * @author ruschka
 *
 */
public abstract class IfIcmpInstruction extends AbstractConditionInstruction {
	
	@Override
	protected boolean evaluateCondition(Frame frame) {
		Reference reference2 = frame.pop();
		Reference reference1 = frame.pop();
		checkInteger(reference1);
		checkInteger(reference2);
		Integer integer1 = ((IntegerObject)reference1.getObject()).getValue();
		Integer integer2 = ((IntegerObject)reference2.getObject()).getValue();
		return compareIntegers(integer1, integer2);
	}
	
	protected abstract boolean compareIntegers(Integer integer1, Integer integer2);

}
