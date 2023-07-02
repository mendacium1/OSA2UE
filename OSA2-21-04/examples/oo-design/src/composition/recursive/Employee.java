package composition.recursive;

public class Employee {

	private static final int MAX_NUMBER_OF_COLLEAGUES = 5;
	Employee[] colleagues;
	int numberOfColleagues;

	public Employee() {
		colleagues = new Employee[MAX_NUMBER_OF_COLLEAGUES];
		numberOfColleagues = 0;
	}

	void addColleague(final Employee colleague) {
		if (numberOfColleagues < MAX_NUMBER_OF_COLLEAGUES) {
			colleagues[numberOfColleagues] = colleague;
			numberOfColleagues++;
		}
	}

}
