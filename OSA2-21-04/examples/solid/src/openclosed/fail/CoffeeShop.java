package openclosed.fail;

import openclosed.CoffeeSelection;

public class CoffeeShop {

	public static void main(String[] args) {
		TheCoffeeMachine machine = new TheCoffeeMachine();

		System.out.println(machine.brew(CoffeeSelection.MELANGE));

		// machine = new TheNewAndImprovedCoffeeMachine();
		//
		// System.out.println(machine.brew(CoffeeSelection.AMERICANO));
	}

}
