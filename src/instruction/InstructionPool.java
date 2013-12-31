package instruction;

import instruction.condition.IfIcmpeqInstruction;
import instruction.condition.IfIcmpgeInstruction;
import instruction.condition.IfIcmpgtInstruction;
import instruction.condition.IfIcmpleInstruction;
import instruction.condition.IfIcmpltInstruction;
import instruction.condition.IfIcmpneInstruction;
import instruction.condition.IfeqCondition;
import instruction.condition.IfgeCondition;
import instruction.condition.IfgtCondition;
import instruction.condition.IfleCondition;
import instruction.condition.IfltCondition;
import instruction.condition.IfneCondition;
import instruction.integer.iarithmetic.IaddInstruction;
import instruction.integer.iarithmetic.IdivInstruction;
import instruction.integer.iarithmetic.ImulInstruction;
import instruction.integer.iarithmetic.IsubInstruction;
import instruction.integer.iconst.Iconst0Instruction;
import instruction.integer.iconst.Iconst1Instruction;
import instruction.integer.iconst.Iconst2Instruction;
import instruction.integer.iconst.Iconst3Instruction;
import instruction.integer.iconst.Iconst4Instruction;
import instruction.integer.iconst.Iconst5Instruction;
import instruction.integer.iload.Iload0Instruction;
import instruction.integer.iload.Iload1Instruction;
import instruction.integer.iload.Iload2Instruction;
import instruction.integer.iload.Iload3Instruction;
import instruction.integer.iload.IloadInstruction;
import instruction.integer.istore.Istore0Instruction;
import instruction.integer.istore.Istore1Instruction;
import instruction.integer.istore.Istore2Instruction;
import instruction.integer.istore.Istore3Instruction;
import instruction.integer.istore.IstoreInstruction;
import instruction.object.GetFieldInstruction;
import instruction.object.InvokeSpecialInstruction;
import instruction.object.InvokeVirtualInstruction;
import instruction.object.NewInstruction;
import instruction.object.PutFieldInstruction;
import instruction.object.aload.Aload0Instruction;
import instruction.object.aload.Aload1Instruction;
import instruction.object.aload.Aload2Instruction;
import instruction.object.aload.Aload3Instruction;
import instruction.object.aload.AloadInstruction;
import instruction.object.astore.Astore0Instruction;
import instruction.object.astore.Astore1Instruction;
import instruction.object.astore.Astore2Instruction;
import instruction.object.astore.Astore3Instruction;
import instruction.object.astore.AstoreInstruction;
import instruction.returns.IReturnInstruction;
import instruction.returns.ReturnInstruction;
import instruction.util.DupInstruction;
import instruction.util.PopInstruction;

import java.util.HashMap;
import java.util.Map;

public class InstructionPool {
	
	private static final Map<String, AbstractInstruction> INSTRUCTIONS = new HashMap<String, AbstractInstruction>();
	
	static {
		INSTRUCTIONS.put(Iconst0Instruction.OPCODE, new Iconst0Instruction());
		INSTRUCTIONS.put(Iconst1Instruction.OPCODE, new Iconst1Instruction());
		INSTRUCTIONS.put(Iconst2Instruction.OPCODE, new Iconst2Instruction());
		INSTRUCTIONS.put(Iconst3Instruction.OPCODE, new Iconst3Instruction());
		INSTRUCTIONS.put(Iconst4Instruction.OPCODE, new Iconst4Instruction());
		INSTRUCTIONS.put(Iconst5Instruction.OPCODE, new Iconst5Instruction());
		
		INSTRUCTIONS.put(Istore0Instruction.OPCODE, new Istore0Instruction());
		INSTRUCTIONS.put(Istore1Instruction.OPCODE, new Istore1Instruction());
		INSTRUCTIONS.put(Istore2Instruction.OPCODE, new Istore2Instruction());
		INSTRUCTIONS.put(Istore3Instruction.OPCODE, new Istore3Instruction());
		INSTRUCTIONS.put(IstoreInstruction.OPCODE, new IstoreInstruction());
		
		INSTRUCTIONS.put(Iload0Instruction.OPCODE, new Iload0Instruction());
		INSTRUCTIONS.put(Iload1Instruction.OPCODE, new Iload1Instruction());
		INSTRUCTIONS.put(Iload2Instruction.OPCODE, new Iload2Instruction());
		INSTRUCTIONS.put(Iload3Instruction.OPCODE, new Iload3Instruction());
		INSTRUCTIONS.put(IloadInstruction.OPCODE, new IloadInstruction());
		
		INSTRUCTIONS.put(IaddInstruction.OPCODE, new IaddInstruction());
		INSTRUCTIONS.put(IsubInstruction.OPCODE, new IsubInstruction());
		INSTRUCTIONS.put(ImulInstruction.OPCODE, new ImulInstruction());
		INSTRUCTIONS.put(IdivInstruction.OPCODE, new IdivInstruction());
		
		INSTRUCTIONS.put(Astore0Instruction.OPCODE, new Astore0Instruction());
		INSTRUCTIONS.put(Astore1Instruction.OPCODE, new Astore1Instruction());
		INSTRUCTIONS.put(Astore2Instruction.OPCODE, new Astore2Instruction());
		INSTRUCTIONS.put(Astore3Instruction.OPCODE, new Astore3Instruction());
		INSTRUCTIONS.put(AstoreInstruction.OPCODE, new AstoreInstruction());
		
		INSTRUCTIONS.put(Aload0Instruction.OPCODE, new Aload0Instruction());
		INSTRUCTIONS.put(Aload1Instruction.OPCODE, new Aload1Instruction());
		INSTRUCTIONS.put(Aload2Instruction.OPCODE, new Aload2Instruction());
		INSTRUCTIONS.put(Aload3Instruction.OPCODE, new Aload3Instruction());
		INSTRUCTIONS.put(AloadInstruction.OPCODE, new AloadInstruction());
		
		INSTRUCTIONS.put(ReturnInstruction.OPCODE, new ReturnInstruction());
		INSTRUCTIONS.put(IReturnInstruction.OPCODE, new IReturnInstruction());
		
		INSTRUCTIONS.put(NewInstruction.OPCODE, new NewInstruction());
		INSTRUCTIONS.put(InvokeSpecialInstruction.OPCODE, new InvokeSpecialInstruction());
		INSTRUCTIONS.put(InvokeVirtualInstruction.OPCODE, new InvokeVirtualInstruction());
		INSTRUCTIONS.put(PutFieldInstruction.OPCODE, new PutFieldInstruction());
		INSTRUCTIONS.put(GetFieldInstruction.OPCODE, new GetFieldInstruction());
		
		INSTRUCTIONS.put(DupInstruction.OPCODE, new DupInstruction());
		INSTRUCTIONS.put(PopInstruction.OPCODE, new PopInstruction());
		
		INSTRUCTIONS.put(IfIcmpleInstruction.OPCODE, new IfIcmpleInstruction());
		INSTRUCTIONS.put(IfIcmpltInstruction.OPCODE, new IfIcmpltInstruction());
		INSTRUCTIONS.put(IfIcmpgeInstruction.OPCODE, new IfIcmpgeInstruction());
		INSTRUCTIONS.put(IfIcmpgtInstruction.OPCODE, new IfIcmpgtInstruction());
		INSTRUCTIONS.put(IfIcmpeqInstruction.OPCODE, new IfIcmpeqInstruction());
		INSTRUCTIONS.put(IfIcmpneInstruction.OPCODE, new IfIcmpneInstruction());
		
		INSTRUCTIONS.put(IfeqCondition.OPCODE, new IfeqCondition());
		INSTRUCTIONS.put(IfneCondition.OPCODE, new IfneCondition());
		INSTRUCTIONS.put(IfleCondition.OPCODE, new IfleCondition());
		INSTRUCTIONS.put(IfltCondition.OPCODE, new IfltCondition());
		INSTRUCTIONS.put(IfgeCondition.OPCODE, new IfgeCondition());
		INSTRUCTIONS.put(IfgtCondition.OPCODE, new IfgtCondition());
	}
	
	public static final AbstractInstruction getInstruction(byte b) {
		String key = String.format("%02X", b);
		AbstractInstruction instruction = INSTRUCTIONS.get(key);
		if (instruction == null) {
			throw new IllegalStateException("Instruction " + key + " not found.");
		}
		return instruction;
	}

}
