public class Main {
    public static void main(String[] args) {
        Planet jupiter = Planet.JUPITER;
        String name = jupiter.getPlanetName();
        int numberOfMoons = jupiter.getNumberOfMoons();
        double massRelativeToEarth = jupiter.getMassRelativeToEarth();

        System.out.println(name + ":\n\tMoons: " + numberOfMoons + "\n\tMass: " + massRelativeToEarth);
    }
}

