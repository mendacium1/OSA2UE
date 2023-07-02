package openclosed.fail;

import openclosed.Coffee;

public class TheNewAndImprovedCoffeeMachine {

	public Coffee brew(String type) {
		return new Coffee("The better tasting " + type);
	}

}
