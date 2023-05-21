package philosophers;

public class Dinner {

	public static void main(String[] args) {
		Forks forks = new Forks();

		new Philosopher(0, 5000, 1000, forks).start();
		new Philosopher(1, 4000, 2000, forks).start();
		new Philosopher(2, 3000, 3000, forks).start();
		new Philosopher(3, 2000, 4000, forks).start();
		new Philosopher(4, 1000, 5000, forks).start();

	}

}
