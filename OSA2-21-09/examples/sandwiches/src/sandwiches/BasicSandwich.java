package sandwiches;

import java.util.Arrays;
import java.util.List;

public class BasicSandwich implements Sandwich {

	@Override
	public List<String> getIngredients() {
		return Arrays.asList("bread", "butter");
	}

}
