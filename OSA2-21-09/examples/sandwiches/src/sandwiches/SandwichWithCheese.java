package sandwiches;

import java.util.ArrayList;
import java.util.List;

public class SandwichWithCheese implements Sandwich {

	private final Sandwich baseSandwich;

	public SandwichWithCheese(final Sandwich baseSandwich) {
		this.baseSandwich = baseSandwich;
	}

	@Override
	public List<String> getIngredients() {
		List<String> ingredients = new ArrayList<>(baseSandwich.getIngredients());
		ingredients.add("cheese");
		return ingredients;
	}

}
