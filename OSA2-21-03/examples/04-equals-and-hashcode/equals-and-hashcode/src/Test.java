import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		Person p1 = new Person("Donald", "Duck", LocalDate.of(1986, 3, 12));
		Person p2 = new Person("Daisy", "Duck", LocalDate.of(1988, 6, 28));
		Person p3 = new Person("Donald", "Duck", LocalDate.of(1986, 3, 12));

		if (p1.equals(p2)) {
			System.out.println("equal");
		} else {
			System.out.println("NOT equal");
		}

	}

}
