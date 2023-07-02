package beans;

import java.time.LocalDate;
import java.time.Period;

public class Person {

	private String firstname;
	private String lastname;

	private String nickname;

	private LocalDate dateOfBirth;

	public Person() {
		// no op
	}

	public Person(String firstname, String lastname, LocalDate dateOfBirth) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return Period.between(dateOfBirth, LocalDate.now()).getYears();
	}
}
