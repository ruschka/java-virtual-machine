package object;

public class SimulatedString extends SimulatedObject<String> {
	
	public SimulatedString() {
		super();
	}
	
	public SimulatedString(String string) {
		super(string);
	}
	
	public static String CLASS_NAME = "java/lang/String";

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}
