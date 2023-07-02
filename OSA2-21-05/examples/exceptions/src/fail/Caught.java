package fail;

public class Caught {

	public static void main(String[] args) {
		Caught example = new Caught();

		System.out.println("I'll try something:");

		try {
			example.fail();
			System.out.println("It worked!");
		} catch (Exception e) {
			System.out.println("Something went wrong: " + e.getMessage());
		}

		System.out.println("Wrapping things up...");
	}

	public void fail() throws Exception {
		throw new Exception("Sorry.");
	}

}
