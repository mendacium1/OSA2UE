package rental;

/**
 * Test class for a bike rental service.
 * <p>
 * This example shows basic thread co-operation techniques.
 */
public class BikerTest {

	/**
	 * Simulates a bike rental service.
	 * <p>
	 * The bike rental service offers a pool of 3 bikes.
	 * <p>
	 * There are five bikers trying to rent a bike for a tour.
	 *
	 * @param args
	 *            not used
	 */
	public static void main(final String[] args) {

		BikePool bikes = new BikePool(3);

		System.out.println("Bike Rental is lending 3 bikes");

		Biker b1 = new Biker("Tim", bikes);
		Biker b2 = new Biker("Tom", bikes);
		Biker b3 = new Biker("Colin", bikes);
		Biker b4 = new Biker("Ralph", bikes);
		Biker b5 = new Biker("John", bikes);

		b1.start();
		b2.start();
		b3.start();
		b4.start();
		b5.start();

	}

}
