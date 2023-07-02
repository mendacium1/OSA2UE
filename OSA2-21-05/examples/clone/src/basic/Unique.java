package basic;


public class Unique {

	private String value;

	public Unique(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Unique unique = new Unique("test");
		Object clone = unique.clone();

		System.out.println(String.format("%s: %s", unique.getClass(), unique));
		System.out.println(String.format("%s: %s", clone.getClass(), clone));
	}

}
