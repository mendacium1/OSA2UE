package alternatives;

import java.time.LocalDate;

public class Person {

	String firstname;
	String lastname;

	LocalDate dateOfBirth;

	public Person(final String firstname, final String lastname, final LocalDate dateOfBirth) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
	}

	public Person(Person person) {
		this.firstname = person.firstname;
		this.lastname = person.lastname;
		this.dateOfBirth = person.dateOfBirth;
	}

	public static Person copy(Person person) {
		return new Person(person.firstname, person.lastname, person.dateOfBirth);
	}

	@Override
	public String toString() {
		return String.format("%s: %s %s (%s)", super.toString(), firstname, lastname, dateOfBirth);
	}

}
