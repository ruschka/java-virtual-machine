package object;

public class IntegerObject extends PrimitiveObject<Integer> {
	
	private Integer value;

	public IntegerObject(Integer value) {
		super();
		this.value = value;
	}
	
	@Override
	public Integer getValue() {
		return value;
	}

}
