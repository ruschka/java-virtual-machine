package instruction;

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
import instruction.integer.istore.Istore0Instruction;
import instruction.integer.istore.Istore1Instruction;
import instruction.integer.istore.Istore2Instruction;
import instruction.integer.istore.Istore3Instruction;
import instruction.integer.istore.IstoreInstruction;
import instruction.returns.ReturnInstruction;

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
		
		INSTRUCTIONS.put(IaddInstruction.OPCODE, new IaddInstruction());
		INSTRUCTIONS.put(IsubInstruction.OPCODE, new IsubInstruction());
		INSTRUCTIONS.put(ImulInstruction.OPCODE, new ImulInstruction());
		INSTRUCTIONS.put(IdivInstruction.OPCODE, new IdivInstruction());
		
		INSTRUCTIONS.put(ReturnInstruction.OPCODE, new ReturnInstruction());
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
