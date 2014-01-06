package instruction;

import instruction.array.ArrayLenghtInstruction;
import instruction.array.NewArrayInstruction;
import instruction.array.NewObjectArrayInstruction;
import instruction.array.load.AArrayLoadInstruction;
import instruction.array.load.IArrayLoadInstruction;
import instruction.array.store.AArrayStoreInstruction;
import instruction.array.store.BArrayStoreInstruction;
import instruction.array.store.IArrayStoreInstruction;
import instruction.condition.IfIcmpeqInstruction;
import instruction.condition.IfIcmpgeInstruction;
import instruction.condition.IfIcmpgtInstruction;
import instruction.condition.IfIcmpleInstruction;
import instruction.condition.IfIcmpltInstruction;
import instruction.condition.IfIcmpneInstruction;
import instruction.condition.IfeqInstruction;
import instruction.condition.IfgeInstruction;
import instruction.condition.IfgtInstruction;
import instruction.condition.IfleInstruction;
import instruction.condition.IfltInstruction;
import instruction.condition.IfneInstruction;
import instruction.integer.iarithmetic.IaddInstruction;
import instruction.integer.iarithmetic.IdivInstruction;
import instruction.integer.iarithmetic.ImulInstruction;
import instruction.integer.iarithmetic.IsubInstruction;
import instruction.integer.iconst.BipushInstruction;
import instruction.integer.iconst.Iconst0Instruction;
import instruction.integer.iconst.Iconst1Instruction;
import instruction.integer.iconst.Iconst2Instruction;
import instruction.integer.iconst.Iconst3Instruction;
import instruction.integer.iconst.Iconst4Instruction;
import instruction.integer.iconst.Iconst5Instruction;
import instruction.integer.iconst.Iconstm1Instruction;
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
import instruction.object.GetStaticInstruction;
import instruction.object.InvokeSpecialInstruction;
import instruction.object.InvokeStaticInstruction;
import instruction.object.InvokeVirtualInstruction;
import instruction.object.NewInstruction;
import instruction.object.PutFieldInstruction;
import instruction.object.PutStaticInstruction;
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
import instruction.util.GotoInstruction;
import instruction.util.IincInstruction;
import instruction.util.LdcInstruction;
import instruction.util.PopInstruction;

import java.util.HashMap;
import java.util.Map;

public class InstructionPool {
	
	private static final Map<String, AbstractInstruction> INSTRUCTIONS = new HashMap<String, AbstractInstruction>();
	
	static {
		addInstruction(new Iconstm1Instruction());
		addInstruction(new Iconst0Instruction());
		addInstruction(new Iconst1Instruction());
		addInstruction(new Iconst2Instruction());
		addInstruction(new Iconst3Instruction());
		addInstruction(new Iconst4Instruction());
		addInstruction(new Iconst5Instruction());
		addInstruction(new BipushInstruction());
		
		addInstruction(new Istore0Instruction());
		addInstruction(new Istore1Instruction());
		addInstruction(new Istore2Instruction());
		addInstruction(new Istore3Instruction());
		addInstruction(new IstoreInstruction());
		
		addInstruction(new Iload0Instruction());
		addInstruction(new Iload1Instruction());
		addInstruction(new Iload2Instruction());
		addInstruction(new Iload3Instruction());
		addInstruction(new IloadInstruction());
		
		addInstruction(new IaddInstruction());
		addInstruction(new IsubInstruction());
		addInstruction(new ImulInstruction());
		addInstruction(new IdivInstruction());
		
		addInstruction(new Astore0Instruction());
		addInstruction(new Astore1Instruction());
		addInstruction(new Astore2Instruction());
		addInstruction(new Astore3Instruction());
		addInstruction(new AstoreInstruction());
		
		addInstruction(new Aload0Instruction());
		addInstruction(new Aload1Instruction());
		addInstruction(new Aload2Instruction());
		addInstruction(new Aload3Instruction());
		addInstruction(new AloadInstruction());
		
		addInstruction(new ReturnInstruction());
		addInstruction(new IReturnInstruction());
		
		addInstruction(new NewInstruction());
		addInstruction(new InvokeSpecialInstruction());
		addInstruction(new InvokeStaticInstruction());
		addInstruction(new InvokeVirtualInstruction());
		addInstruction(new PutFieldInstruction());
		addInstruction(new GetFieldInstruction());
		addInstruction(new PutStaticInstruction());
		addInstruction(new GetStaticInstruction());
		
		addInstruction(new DupInstruction());
		addInstruction(new PopInstruction());
		addInstruction(new IincInstruction());
		addInstruction(new GotoInstruction());
		addInstruction(new LdcInstruction());
		
		addInstruction(new IfIcmpleInstruction());
		addInstruction(new IfIcmpltInstruction());
		addInstruction(new IfIcmpgeInstruction());
		addInstruction(new IfIcmpgtInstruction());
		addInstruction(new IfIcmpeqInstruction());
		addInstruction(new IfIcmpneInstruction());
		
		addInstruction(new IfeqInstruction());
		addInstruction(new IfneInstruction());
		addInstruction(new IfleInstruction());
		addInstruction(new IfltInstruction());
		addInstruction(new IfgeInstruction());
		addInstruction(new IfgtInstruction());
		
		addInstruction(new NewArrayInstruction());
		addInstruction(new NewObjectArrayInstruction());
		addInstruction(new IArrayStoreInstruction());
		addInstruction(new AArrayStoreInstruction());
		addInstruction(new BArrayStoreInstruction());
		addInstruction(new IArrayLoadInstruction());
		addInstruction(new AArrayLoadInstruction());
		addInstruction(new ArrayLenghtInstruction());
	}
	
	public static final AbstractInstruction getInstruction(byte b) {
		String key = String.format("%02X", b);
		AbstractInstruction instruction = INSTRUCTIONS.get(key);
		if (instruction == null) {
			throw new IllegalStateException("Instruction " + key + " not found.");
		}
		return instruction;
	}
	
	private static void addInstruction(AbstractInstruction instruction) {
		INSTRUCTIONS.put(instruction.getOpcode(), instruction);
	}

}
