package philosophers;

/**
 * Philosopher represent the working threads.
 *
 * @author Claudia
 * @version 1.0
 */
public class Philosopher extends Thread {
	private int id;

	private int thinkTime;
	private int eatTime;

	private Forks forks;

	public Philosopher(int id, int thinkTime, int eatTime, Forks forks) {
		this.id = id;
		this.thinkTime = thinkTime;
		this.eatTime = eatTime;
		this.forks = forks;
	}

	@Override
	public void run() {
		try {
			for (;;) {
				Thread.sleep(thinkTime);

				System.out.println("Philosopher " + id + " tries to take forks");
				forks.grab(id, (id + 1) % 5);

				System.out.println("Philosopher " + id + " is eating.");
				Thread.sleep(eatTime);

				forks.release(id, (id + 1) % 5);
			}
		} catch (InterruptedException e) {
		}
	}

}
