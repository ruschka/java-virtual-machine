package garbagecollector;

import enviroment.Frame;
import enviroment.Heap;

public interface IGarbageCollector {
	
	public void run(Heap heap, Frame actualFrame);

}
