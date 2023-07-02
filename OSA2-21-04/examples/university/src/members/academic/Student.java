package members.academic;

import java.time.LocalDate;

import members.Person;

public class Student extends Person {

	public static String getIdentifier() {
		return "Student";
	}

	private final String enrolmentNumber;

	public Student(final String firstname, final String lastname, final LocalDate dateOfBirth,
			final String enrolmentNumber) {
		super(firstname, lastname, dateOfBirth);
		this.enrolmentNumber = enrolmentNumber;
	}

	public String getEnrolmentNumber() {
		return enrolmentNumber;
	}

	@Override
	public String toString() {
		return super.toString() + " (" + enrolmentNumber + ")";
	}

	@Override
	public String toStringAlternative() {
		return super.toStringAlternative() + " (" + enrolmentNumber + ")";
	}

}
