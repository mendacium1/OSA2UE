
public class CivilRegistry {

	public static void main(String[] args) {
		Person donald = new Person("Donald", "Duck", 32);
		Person daisy = new Person("Daisy", "Queen", 27);

		System.out.println(donald);
		System.out.println(daisy);
		System.out.println(String.format("Nr. of marriages: %d, nr. of divorces: %d.\n", Person.nrOfMarriages,
				Person.nrOfDivorces));

		donald.marry(daisy);

		System.out.println(donald);
		System.out.println(daisy);
		System.out.println(String.format("Nr. of marriages: %d, nr. of divorces: %d.\n", Person.nrOfMarriages,
				Person.nrOfDivorces));

		daisy.divorce();

		System.out.println(donald);
		System.out.println(daisy);
		System.out.println(String.format("Nr. of marriages: %d, nr. of divorces: %d.\n", Person.nrOfMarriages,
				Person.nrOfDivorces));
	}

}
