package openclosed.fail;

import openclosed.Coffee;

public class TheCoffeeMachine {

	public Coffee brew(String type) {
		return new Coffee(type);
	}

}
