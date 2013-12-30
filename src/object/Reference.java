package object;

public class Reference {
	
	private AbstractObject<?> object;

	public Reference(AbstractObject<?> object) {
		super();
		this.object = object;
	}

	public AbstractObject<?> getObject() {
		return object;
	}

}
