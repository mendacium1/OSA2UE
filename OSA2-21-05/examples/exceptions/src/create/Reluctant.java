package create;

public class Reluctant {

	Reluctant internal = new Reluctant();

	public Reluctant() throws Exception {
		throw new Exception("I'm not coming out.");
	}

	public static void main(String[] args) {
		try {
			new Reluctant();
			System.out.println("Surprise!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("I told you so...");
		}
	}
}
