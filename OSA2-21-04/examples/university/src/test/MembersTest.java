package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import members.Employee;
import members.Person;
import members.academic.Student;
import members.academic.Teacher;

public class MembersTest {

	public static void main(String[] args) {
		final List<Person> members = new ArrayList<>();

		Person donald = new Person("Donald", "Duck", LocalDate.of(1987, 4, 23));
		Person huey = new Student("Huey", "Duck", LocalDate.of(2010, 2, 17), "S1230001");
		Student dewey = new Student("Dewey", "Duck", LocalDate.of(2010, 2, 17), "S1230002");
		Person louie = new Student("Louie", "Duck", LocalDate.of(2010, 2, 17), "S1230003");
		Person gyro = new Teacher("Gyro", "Gearloose", LocalDate.of(1976, 10, 1), "P450001", "PhD", "Physics");
		Person daisy = new Employee("Daisy", "Duck", LocalDate.of(1988, 1, 27), "P450002");

		System.out.println(donald.getIdentifier());
		System.out.println(huey.getIdentifier());

		members.add(donald);
		members.add(huey);
		members.add(dewey);
		members.add(louie);
		members.add(gyro);
		members.add(daisy);

		for (Person person : members) {
			System.out.print(person.toString());
			if (person instanceof Teacher) {
				Teacher teacher = (Teacher) person;
				System.out.print(" - " + teacher.getFaculty());
			}
			System.out.print("; age " + person.getAge());
			System.out.println();

			System.out.println(person.toStringAlternative());
		}

	}

}
