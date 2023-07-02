
public class Coffee implements Beverage {
	String blend;
	String size;
	float price;

	public Coffee(String blend, String size, float price) {
		this.blend = blend;
		this.size = size;
		this.price = price;
	}

	@Override
	public String getSize() {
		return size;
	}

	@Override
	public float getPrice() {
		return price / 2;
	}

	void brew() {
		System.out.printf("Create %s coffee\n", blend);
	}
}
