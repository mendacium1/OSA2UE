package pair;

public class PairUsage {

	public static void main(String[] args) {

		Pair<String, String> p1 = new Pair<>("Hans", "Herbert");
		Pair<Integer, Short> p2 = new Pair<>(7, (short) 8);

		Pair<String, String> p3;
		p3 = p1;
		// p3 = p2;

	}

}
