package object;

public class ArrayObject extends ComplexObject {
	
	private Reference[] array;
	
	public ArrayObject(int lenght) {
		array = new Reference[lenght];
	}
	
	public void putValue(int index, AbstractObject object) {
		checkIndex(index);
		array[index] = new Reference(object);
	}
	
	public Reference getValue(int index) {
		checkIndex(index);
		return array[index];
	}
	
	private void checkIndex(int index) {
		if (index < 0 || index >= array.length) {
			throw new IllegalStateException("Index has to be equal or higher than 0 and lower then array lenght.");
		}
	}

}
