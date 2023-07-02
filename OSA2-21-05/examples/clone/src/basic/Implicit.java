package basic;

public class Implicit implements Cloneable {

	private String value;

	public Implicit(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Implicit ordinary = new Implicit("test");
		Implicit clone = (Implicit) ordinary.clone();

		System.out.println(String.format("%s: %s", ordinary.getClass(), ordinary));
		System.out.println(String.format("%s: %s", clone.getClass(), clone));
	}
}
