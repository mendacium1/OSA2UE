
public class FancyCoffee extends Coffee {

	public FancyCoffee(String blend, String size, float price) {
		super(blend, size, price);
	}

	@Override
	public float getPrice() {
		return super.getPrice() * 1.25f;
	}
}
