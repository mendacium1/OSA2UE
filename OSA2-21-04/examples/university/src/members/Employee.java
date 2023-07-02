package members;

import java.time.LocalDate;

public class Employee extends Person implements Staff {

	public static String getIdentifier() {
		return "Employee";
	}

	private final String staffNumber;

	public Employee(String firstname, String lastname, LocalDate dateOfBirth, final String staffNumber) {
		super(firstname, lastname, dateOfBirth);
		this.staffNumber = staffNumber;
	}

	@Override
	public String getStaffNumber() {
		return staffNumber;
	}

	@Override
	public String toString() {
		return super.toString() + " (" + staffNumber + ")";
	}

	@Override
	public String toStringAlternative() {
		return super.toStringAlternative() + " (" + staffNumber + ")";
	}

}
