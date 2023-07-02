package members;

import java.time.LocalDate;
import java.time.Period;

public class Person {

	public static String getIdentifier() {
		return "Person";
	}

	private final String firstname;
	private final String lastname;

	private final LocalDate dateOfBirth;

	public Person(final String firstname, final String lastname, final LocalDate dateOfBirth) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public int getAge() {
		return Period.between(dateOfBirth, LocalDate.now()).getYears();
	}

	protected String getFullname() {
		return firstname + " " + lastname;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ": " + getFullname();
	}

	public String toStringAlternative() {
		return Person.getIdentifier() + ": " + getFullname();
	}
}
