package object;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	
	private List<AbstractObject<?>> objects = new ArrayList<AbstractObject<?>>();
	
	public void addObject(AbstractObject<?> object) {
		objects.add(object);
	}
	
}
