package enviroment;

import java.util.LinkedList;

import object.Reference;

public class Frame {
	
	private Frame parent;
	private LinkedList<Reference> stack = new LinkedList<Reference>();
	private Reference[] localVariables;
	
	public Frame(Frame parent, int countOfLocals) {
		super();
		this.parent = parent;
		localVariables = new Reference[countOfLocals];
	}
	
	public Frame getParent() {
		return parent;
	}

	public void push(Reference reference) {
		stack.addFirst(reference);
	}
	
	public Reference pop() {
		return stack.removeFirst();
	}
	
	public void setLocal(int index, Reference reference) {
		localVariables[index] = reference;
	}
	
	public Reference getLocal(int index) {
		return localVariables[index];
	}

}
