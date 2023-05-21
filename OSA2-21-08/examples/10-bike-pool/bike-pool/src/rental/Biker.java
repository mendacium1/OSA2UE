package rental;

import java.util.Random;

/**
 * Instances of this class represent bikers.
 * <p>
 * The bikers try to lend a bike from the bike pool to make a tour.
 */
public class Biker extends Thread {

	private static final int BREAK_TIME = 2000;

	private int toursAlreadyMade;

	private final BikePool bikes;

	/**
	 * @param name
	 *            the name of the biker
	 * @param bikes
	 */
	Biker(final String name, final BikePool bikes) {
		this.setName(name);
		this.bikes = bikes;

		this.toursAlreadyMade = 0;
	}

	/**
	 * @return the number of tours finished by this biker
	 */
	public int getToursAlreadyMade() {
		return this.toursAlreadyMade;
	}

	/**
	 * The biker repeatedly tries to lend a bike to make a tour.
	 */
	@Override
	public void run() {
		int bikeId = 0;

		while (true) {
			try {
				bikeId = this.bikes.lendBike(this);

				int timeForTour = new Random().nextInt(12000);
				System.out.println(
						"Biker " + this.getName() + " (" + this.toursAlreadyMade + " tours overall) is driving on bike "
								+ (bikeId + 1) + " for " + ((float) timeForTour / 1000) + " seconds now ...");
				sleep(timeForTour);
				this.toursAlreadyMade++;

				this.bikes.returnBike(bikeId);

				sleep(BREAK_TIME);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
