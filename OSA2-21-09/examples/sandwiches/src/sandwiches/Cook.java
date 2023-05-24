package sandwiches;

import java.util.stream.Collectors;

public class Cook {

	public static void main(String[] args) {

		BasicSandwich baseSandwich = new BasicSandwich();
		System.out.println(
				new SandwichWithHam(baseSandwich).getIngredients().stream().collect(Collectors.joining(", ")));

		System.out.println(new SandwichWithCheese(new SandwichWithCucumber(new SandwichWithHam(baseSandwich)))
				.getIngredients().stream().collect(Collectors.joining(", ")));

		System.out.println(new SandwichWithCheese(new SandwichWithHam(
				new SandwichWithCheese(new SandwichWithCucumber(new SandwichWithHam(baseSandwich)))))
						.getIngredients().stream().collect(Collectors.joining(", ")));

	}

}
