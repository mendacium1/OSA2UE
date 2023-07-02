package fail;

public class Chained {

	public static void main(String[] args) {
		Chained example = new Chained();

		System.out.println("I'll try something:");

		try {
			example.fail();
			System.out.println("It worked!");
		} catch (Exception e) {
			System.err.println("Something went wrong: " + e.getMessage());
			throw new RuntimeException("I don't know what to do with this.", e);
		}

		System.out.println("Wrapping things up...");
	}

	public void fail() throws Exception {
		throw new Exception("Sorry.");
	}

}
