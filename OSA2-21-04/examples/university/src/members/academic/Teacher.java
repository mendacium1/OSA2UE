package members.academic;

import java.time.LocalDate;

import members.Employee;

public class Teacher extends Employee {

	public static String getIdentifier() {
		return "Teacher";
	}

	private final String title;
	private final String faculty;

	public Teacher(final String firstname, final String lastname, final LocalDate dateOfBirth, final String staffNumber,
			final String title, final String faculty) {
		super(firstname, lastname, dateOfBirth, staffNumber);
		this.title = title;
		this.faculty = faculty;
	}

	public String getTitle() {
		return title;
	}

	public String getFaculty() {
		return faculty;
	}

	@Override
	protected String getFullname() {
		return super.getFullname() + ", " + title;
	}

}
