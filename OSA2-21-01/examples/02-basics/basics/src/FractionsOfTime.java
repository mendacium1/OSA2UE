public class FractionsOfTime {

	public static void main(String[] args) {
		failure();
//		fix();
	}

	static void failure() {
		final long microsPerDay = 24 * 60 * 60 * 1000 * 1000;
		final long millisPerDay = 24 * 60 * 60 * 1000;
		System.out.println(microsPerDay / millisPerDay);
	}

	static void fix() {
		final long microsPerDay = 24 * 60 * 60 * 1000 * 1000L;
		final long millisPerDay = 24 * 60 * 60 * 1000;
		System.out.println(microsPerDay / millisPerDay);
	}
}
