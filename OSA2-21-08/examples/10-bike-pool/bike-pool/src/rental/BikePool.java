package rental;

/**
 * An instance of this class manages the bike pool of a bike rental service.
 * <p>
 * The number of bikes is limited to the capacity given in the constructor.
 */
public class BikePool {

	/**
	 * This array represents the availability state of the bikes in the bike pool.
	 * <p>
	 * {@code true} means the bike is currently loaned and therefore not available. {@code false} means the bike is
	 * available for lending.
	 */
	private final boolean[] bikes;

	/**
	 * Create a new bike pool with the given capacity.
	 *
	 * @param capacity
	 *            the number of bikes available in the bike pool
	 */
	public BikePool(final int capacity) {
		this.bikes = new boolean[capacity];
	}

	/**
	 * @param biker
	 *            trying to lend a bike
	 * @return the identifier of the bike lended to the biker
	 */
	public synchronized int lendBike(final Biker w) {
		try {
			while (true) {
				for (int i = 0; i < this.bikes.length; i++) {
					if (!this.bikes[i]) {
						this.bikes[i] = true;
						return i;
					}
				}
				System.out.println("Biker " + w.getName() + " is waiting for a free bike...");
				this.wait();
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return -1;
		}
	}

	/**
	 * Returns a bike to the bike pool.
	 * <p>
	 * Once a bike is returned it is availabe for rental again.
	 *
	 * @param i
	 *            the identifier of the bike returned to the pool
	 */
	public synchronized void returnBike(final int i) {
		if ((i < this.bikes.length) && this.bikes[i]) {
			this.bikes[i] = false;
			this.notifyAll();
		}
	}
}
