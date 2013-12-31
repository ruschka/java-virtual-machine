package instruction.condition;

import object.IntegerObject;
import object.Reference;
import enviroment.Frame;

/**
 * http://docs.oracle.com/javase/specs/jvms/se7/html/jvms-6.html#jvms-6.5.if_cond
 * @author ruschka
 *
 */
public abstract class IfInstruction extends AbstractConditionInstruction {

	@Override
	protected boolean evaluateCondition(Frame frame) {
		Reference reference = frame.pop();
		checkInteger(reference);
		Integer integer = ((IntegerObject)reference.getObject()).getValue();
		return compare(integer);
	}
	
	protected abstract boolean compare(Integer integer);

}
