package alternatives;

import java.time.LocalDate;

public class Copier {

	public static Person copy(Person person) {
		if (person instanceof User) {
			return new User((User) person);
		}
		return new Person(person);
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		copyConstructor();

		System.out.println();

		factory();

		System.out.println();

		factory2();
	}

	private static void copyConstructor() {
		Person original = new Person("Donald", "Duck", LocalDate.of(1970, 5, 20));
		Person copy = new Person(original);

		System.out.println("Original: " + original);
		System.out.println("Copy:     " + copy);

		copy.firstname = "Duffy";

		System.out.println("Original: " + original);
		System.out.println("Copy:     " + copy);
	}

	private static void factory() {
		Person original = new Person("Donald", "Duck", LocalDate.of(1970, 5, 20));
		Person copy = Person.copy(original);

		System.out.println("Original: " + original);
		System.out.println("Copy:     " + copy);

		copy.firstname = "Duffy";

		System.out.println("Original: " + original);
		System.out.println("Copy:     " + copy);
	}

	private static void factory2() {
		Person original = new User("Donald", "Duck", LocalDate.of(1970, 5, 20), "dduck");
		Person copy1 = Person.copy(original);
		Person copy2 = copy(original);

		System.out.println("Original: " + original);
		System.out.println("Copy 1:   " + copy1);
		System.out.println("Copy 2:   " + copy2);
	}
}
