package garbagecollector;

import enviroment.Frame;
import enviroment.Heap;


public abstract class GarbageCollector implements IGarbageCollector {
	
	private static final int START_LIMIT = 100000;
	
	private int counter = 0;
	
	@Override
	public void run(Heap heap, Frame actualFrame) {
		if (!shouldStart()) {
			return;
		}
		System.out.println("Garbage collector start. Heap size: " + heap.getSize());
		collect(heap, actualFrame);
		System.out.println("Garbage collector stop. Heap size: " + heap.getSize());
	}
	
	private final boolean shouldStart() {
		if (counter == START_LIMIT) {
			counter = 0;
			return true;
		} else {
			++counter;
			return false;
		}
	}
	
	protected abstract void collect(Heap heap, Frame actualFrame);

}
