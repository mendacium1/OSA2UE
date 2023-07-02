package openclosed.ok;

import openclosed.Coffee;

public class TheNewAndImprovedCoffeeMachine implements CoffeeMachine {

	public Coffee brew(String type) {
		return new Coffee("The better tasting " + type);
	}

}
