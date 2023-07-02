package fail;

public class Uncaught {

	public static void main(String[] args) {
		Uncaught example = new Uncaught();

		System.out.println("I'll try something:");

		example.fail();
		System.out.println("It worked!");

		System.out.println("Wrapping things up...");
	}

	public void fail() {
		throw new IllegalStateException();
	}

}
