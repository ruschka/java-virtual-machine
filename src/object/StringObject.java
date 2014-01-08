package object;

public class StringObject extends PrimitiveObject<String> {
	
	private String string;
	
	public StringObject(String string) {
		super();
		this.string = string;
	}

	@Override
	public String getValue() {
		return string;
	}

}
