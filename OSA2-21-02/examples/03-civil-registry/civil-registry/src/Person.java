/**
 * This class represents a human person and her or his civil status.
 *
 * @author Claudia
 * @version 1.0
 */
public class Person {

	/**
	 * Overall number of marriages.
	 */
	static int nrOfMarriages = 0;
	/**
	 * Overall number of divorces.
	 */
	static int nrOfDivorces = 0;

	String firstname;
	String lastname;
	/**
	 * The birthname of a married woman.
	 * <p>
	 * This value is only set for currently married woman, otherwise this attribute is <code>null</code>.
	 */
	String birthname;
	/**
	 * The person's age in years.
	 */
	int age;

	/**
	 * This attribute references the spouse if this person is married; otherwise it is <code>null</code>.
	 */
	Person partner;

	/**
	 * @return the overall number of marriages
	 */
	public static int getNumberOfMarriages() {
		return nrOfMarriages;
	}

	/**
	 * @return the overall number of divorces
	 */
	public static int getNumberOfDivorces() {
		return nrOfDivorces;
	}

	/**
	 * @return the current number of married couples
	 */
	public static int getNumberOfCouples() {
		return nrOfMarriages - nrOfDivorces;
	}

	/**
	 * Create a new person.
	 *
	 * @param firstname
	 * @param lastname
	 * @param age
	 */
	public Person(String firstname, String lastname, int age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	/**
	 * Marry this person with the given other person.
	 * <p>
	 * Marriage is only allow for
	 * <ul>
	 * <li>person with a minimum age of 18
	 * <li>persons which are not already married
	 * </ul>
	 *
	 * @param p
	 */
	void marry(Person p) {
		// check preconditions
		if (partner == p) {
			System.out.println("Marriage is not possible: self marriage is not possible.");
		}
		if ((partner != null) || (p.partner != null)) {
			System.out.println("Marriage is not possible: at least one of the partners is already married.");
			return;
		}
		if ((age < 18) || (p.age < 18)) {
			System.out.println("Marriage not possible: at least one of the partners is too young.");
			return;
		}
		// execute wedding
		partner = p;
		p.partner = this;

		birthname = lastname;
		p.birthname = p.lastname;
		lastname = p.lastname = birthname + "-" + p.birthname;

		nrOfMarriages++;
	}

	/**
	 * Divorce this person from its spouse.
	 */
	void divorce() {
		// check preconditions
		if (partner == null) {
			System.out.println("Divorce is not possible: person is not married.");
			return;
		}

		// execute divorce
		lastname = birthname;
		partner.lastname = partner.birthname;

		partner.partner = null;
		partner = null;

		nrOfDivorces++;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append(firstname).append(" ").append(lastname);
		if (birthname != null) {
			b.append(", birthname: ").append(birthname);
		}
		b.append(", age: ").append(age);
		if (partner != null) {
			b.append(", married to " + partner.firstname + " " + partner.lastname);
		}
		return b.toString();
	}
}
