package openclosed.ok;

import openclosed.CoffeeSelection;

public class CoffeeShop {

	public static void main(String[] args) {
		CoffeeMachine machine = new TheCoffeeMachine();

		System.out.println(machine.brew(CoffeeSelection.MELANGE));

		machine = new TheNewAndImprovedCoffeeMachine();

		System.out.println(machine.brew(CoffeeSelection.AMERICANO));
	}

}
