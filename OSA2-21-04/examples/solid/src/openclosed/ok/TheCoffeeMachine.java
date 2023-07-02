package openclosed.ok;

import openclosed.Coffee;

public class TheCoffeeMachine implements CoffeeMachine {

	public Coffee brew(String type) {
		return new Coffee(type);
	}

}
