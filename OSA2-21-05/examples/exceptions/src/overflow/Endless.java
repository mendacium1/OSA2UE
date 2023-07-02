package overflow;

public class Endless {

	public static void main(String[] args) {
		System.out.println(loop("foo"));
	}

	private static String loop(String s) {
		return s + loop(s);
	}
}
