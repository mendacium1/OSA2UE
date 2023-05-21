/**
 * An enumeration representing the planets in our solar system.
 *
 * @author Jakob Mayr
 */
public enum Planet {

    MERCURY("Mercury", 0, 0.055270),

    VENUS("Venus", 0, 0.81499),

    EARTH("Earth", 1, 1),

    MARS("Mars", 2, 0.10745),

    JUPITER("Jupiter", 79, 317.84),

    SATURN("Saturn", 82, 95.169),

    URANUS("Uranus", 27, 14.539),

    NEPTUNE("Neptune", 14, 17.149);

    private final String planetName;
    private final int numberOfMoons;
    private final double massRelativeToEarth;

    /**
     * Constructor for the Planet enumeration.
     *
     * @param planetName the name of the planet
     * @param numberOfMoons the number of moons orbiting the planet
     * @param massRelativeToEarth the mass of the planet relative to the Earth
     */
    private Planet(final String planetName, final int numberOfMoons, final double massRelativeToEarth){
        this.planetName = planetName;
        this.numberOfMoons = numberOfMoons;
        this.massRelativeToEarth = massRelativeToEarth;
    }

    public String getPlanetName() {
        return planetName;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    public double getMassRelativeToEarth() {
        return massRelativeToEarth;
    }
}
