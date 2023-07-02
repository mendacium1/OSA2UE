
public class BeveragesTest {

	public static void main(String[] args) {
		Beverage[] drinks = new Beverage[3];

		drinks[0] = new Coffee("java", Beverage.SMALL, 5.5f);
		drinks[1] = new Softdrink("orange", Beverage.LARGE, 6.8f);
		drinks[2] = new Coffee("arabica", Beverage.MEDIUM, 7.5f);

		for (Beverage beverage : drinks) {
			System.out.println("Price: " + beverage.getPrice() + ", size: " + beverage.getSize());

			if (beverage instanceof Coffee) {
				Coffee coffee = (Coffee) beverage;
				coffee.brew();
			}
		}
	}

}
