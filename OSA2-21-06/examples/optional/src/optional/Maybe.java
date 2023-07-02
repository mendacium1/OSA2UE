package optional;

import java.util.List;
import java.util.Optional;

public class Maybe {

	private static List<String> NAMES = List.of("Tick", "Trick", "Truck");

	private static String find(final String name) {
		for (String string : NAMES) {
			if (string.equals(name)) {
				return string;
			}
		}
		return null;
	}

	private static Optional<String> findImproved(final String name) {
		for (String string : NAMES) {
			if (string.equals(name)) {
				return Optional.of(string);
			}
		}
		return Optional.empty();
	}

	public static void main(String[] args) {
		find("Trick").length();
//		find("Donald").length();

		Optional<String> name = findImproved("Donald");
		if (name.isPresent()) {
			name.get().length();
		} else {
			System.out.println("Name not found.");
		}
	}

}
