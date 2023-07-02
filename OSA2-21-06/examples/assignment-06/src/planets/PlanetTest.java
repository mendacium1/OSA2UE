package planets;

public class PlanetTest {
	public static void main(String[] args) {
		Planet jupiter = Planet.JUPITER;
		String name = jupiter.getPlanetName();
		int numberOfMoons = jupiter.getNumberOfMoons();
		double massRelativeToEarth = jupiter.getMassRelativeToEarth();
	}
}
