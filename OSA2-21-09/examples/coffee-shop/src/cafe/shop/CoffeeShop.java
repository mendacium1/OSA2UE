package cafe.shop;

import cafe.Coffee;
import cafe.factory.CoffeeFactory;

public class CoffeeShop {
	public static void main(String[] args) {
		CoffeeFactory factory = new CoffeeFactory();

		Coffee coffee1 = factory.getCoffee();
		coffee1.brew();

		factory.getCoffee("macchiato").brew();
		factory.getCoffee("AMERICANO").brew();
		factory.getCoffee("justgivemecoffeeeeee").brew();

		factory.getCoffee(null).brew();
	}
}
