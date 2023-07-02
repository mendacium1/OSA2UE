package variance;

public class Number extends Thing {

	public Number(Integer number) {
		super(number);
	}

	@Override
	Integer getThing() {
		return (Integer) thing;
	}
}
