package planets;

/**
 * Enumeration representing the planets according to the International Astronomical Union (IAU) (2006).
 */
public enum Planet {
	MERCURY("Mercury", 0, 0.055),
	VENUS("Venus", 0, 0.815),
	EARTH("Earth", 1, 1),
	MARS("Mars", 2, 0.107),
	JUPITER("Jupiter", 95, 318),
	SATURN("Saturn", 83, 95),
	URANUS("Uranus", 27, 14.5),
	NEPTUNE("Mercury", 14, 17);

	private final String planetName;
	private final int numberOfMoons;

	private final double massRelativeToEarth;

	Planet(String name, int numberOfMoons, double massRelativeToEarth) {
		this.planetName = name;
		this.numberOfMoons = numberOfMoons;
		this.massRelativeToEarth = massRelativeToEarth;
	}

	/**
	 * @return the english name of the planet
	 */
	public String getPlanetName() {
		return planetName;
	}

	/**
	 * @return the number of natural satellites
	 */
	public int getNumberOfMoons() {
		return numberOfMoons;
	}

	/**
	 * @return the mass of the planet relative to the mass of planet earth (5.972×10^24 kg)
	 */
	public double getMassRelativeToEarth() {
		return massRelativeToEarth;
	}
}
