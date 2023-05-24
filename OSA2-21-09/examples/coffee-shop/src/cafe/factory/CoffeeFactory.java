package cafe.factory;

import cafe.Americano;
import cafe.Coffee;
import cafe.Espresso;
import cafe.Macchiato;
import cafe.Ristretto;

public class CoffeeFactory {

	private static final String DEFAULT_TYPE = "espresso";

	public Coffee getCoffee() {
		return getCoffee(DEFAULT_TYPE);
	}

	public Coffee getCoffee(final String type) {
		switch (type == null ? DEFAULT_TYPE : type.toLowerCase()) {
			case "americano":
				return new Americano();
			case "macchiato":
				return new Macchiato();
			case "ristretto":
				return new Ristretto();
			default:
				return new Espresso();
		}
	}

}
