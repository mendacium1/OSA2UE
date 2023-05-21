package philosophers;

/**
 * Forks represents the resources.
 *
 * @author Claudia
 * @version 1.0
 */
public class Forks {

	/**
	 * A taken fork is represented by <code>true</code>. A fork available for
	 * use is represented by <code>false</code>.
	 */
	private boolean[] forks;

	/**
	 * Create 5 forks.
	 */
	public Forks() {
		forks = new boolean[5];
	}

	public synchronized void grab(int leftid, int rightid) {

		while (forks[leftid] || forks[rightid]) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		forks[leftid] = true;
		forks[rightid] = true;
	}

	public synchronized void release(int leftid, int rightid) {
		forks[leftid] = false;
		forks[rightid] = false;
		notifyAll();
	}
}
