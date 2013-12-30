package object;

public class IntegerObject extends AbstractObject<Integer> {
	
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
