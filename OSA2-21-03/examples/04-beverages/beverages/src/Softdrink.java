
public class Softdrink implements Beverage {
	String flavour;
	String size;
	float price;

	public Softdrink(String blend, String size, float price) {
		this.flavour = blend;
		this.size = size;
		this.price = price;
	}

	@Override
	public String getSize() {
		return size;
	}

	@Override
	public float getPrice() {
		return price;
	}

}
