package pop;

public class Main {

	public static void main(String[] args) {

		for (Beatle member : Beatle.values()) {
			System.out.println(member + ": " + member.getFullname());
			member.play();
		}

		Beatle favourite = Beatle.GEORGE;

		System.out.println("\nMy favourite Beatle is " + favourite.getFirstname());

		Beatle.PAUL.sayHelloTo("Mick");
		Beatle.GEORGE.sayHelloTo("James");

	}

}
