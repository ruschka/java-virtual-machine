package enviroment;

import java.util.ArrayList;
import java.util.List;

import object.AbstractObject;

public class Heap {
	
	private List<AbstractObject> objects = new ArrayList<AbstractObject>();
	
	public void addObject(AbstractObject object) {
		objects.add(object);
	}
	
}
