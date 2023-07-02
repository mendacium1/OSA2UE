package alternatives;

import java.time.LocalDate;

public class User extends Person {

	String username;

	public User(String firstname, String lastname, LocalDate dateOfBirth, String username) {
		super(firstname, lastname, dateOfBirth);
		this.username = username;
	}

	public User(User user) {
		super(user);
		this.username = user.username;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + username;
	}
}
