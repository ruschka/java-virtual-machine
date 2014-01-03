package instruction;

import static org.mockito.Mockito.mock;
import instruction.AbstractInstruction.MethodSignatureInfo;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AbstractInstructionTest {
	
	AbstractInstruction instruction;
	
	@Before
	public void setUp() {
		instruction = mock(AbstractInstruction.class, Mockito.CALLS_REAL_METHODS);
	}
	
	@Test
	public void getMethodSignatureInfoTest1() {
		String signature = "()V";
		MethodSignatureInfo info = instruction.getMethodSignatureInfo(signature);
		assertEquals(0, info.argumentCount);
	}
	
	@Test
	public void getMethodSignatureInfoTest2() {
		String signature = "(I)V";
		MethodSignatureInfo info = instruction.getMethodSignatureInfo(signature);
		assertEquals(1, info.argumentCount);
	}
	
	@Test
	public void getMethodSignatureInfoTest3() {
		String signature = "(II)V";
		MethodSignatureInfo info = instruction.getMethodSignatureInfo(signature);
		assertEquals(2, info.argumentCount);
	}
	
	@Test
	public void getMethodSignatureInfoTest4() {
		String signature = "(Ljava/lang/String;)V";
		MethodSignatureInfo info = instruction.getMethodSignatureInfo(signature);
		assertEquals(1, info.argumentCount);
	}
	
	@Test
	public void getMethodSignatureInfoTest5() {
		String signature = "([I)V";
		MethodSignatureInfo info = instruction.getMethodSignatureInfo(signature);
		assertEquals(1, info.argumentCount);
	}

}
