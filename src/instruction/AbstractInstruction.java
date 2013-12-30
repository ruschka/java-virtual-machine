package instruction;

import object.IntegerObject;
import object.Reference;
import enviroment.Frame;
import enviroment.Heap;

public abstract class AbstractInstruction {
	
	public abstract String getOpcode();
	
	/**
	 * Provede danou instrukci.
	 * @param frame aktualni frame.
	 * @param heap heap
	 * @param bytecode bytecode provadene metody.
	 * @param bytecodeIndex bytecodeIndex pred provedenim instrukce.
	 * @return Vrati aktualni bytecodeIndex po provedeni instrukce.
	 */
	public abstract int run(Frame frame, Heap heap, byte[] bytecode, int bytecodeIndex);
	
	protected int getBytecodeIndex(int bytecodeIndex) {
		return bytecodeIndex;
	}
	
	protected int getIntegerFromNextTwoBytes(byte[] bytecode, int bytecodeIndex) {
		return (((int)bytecode[bytecodeIndex]) << 8) + bytecode[bytecodeIndex + 1];
	}
	
	protected void checkInteger(Reference reference) {
		if (!(reference.getObject() instanceof IntegerObject)) {
			throw new IllegalStateException("Object has to be integer.");
		}
	}

}
