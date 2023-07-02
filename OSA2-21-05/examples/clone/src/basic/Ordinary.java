package basic;

public class Ordinary implements Cloneable {

	private String value;

	public Ordinary(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Ordinary ordinary = new Ordinary("test");
		Ordinary clone = (Ordinary) ordinary.clone();

		System.out.println(String.format("%s: %s", ordinary.getClass(), ordinary));
		System.out.println(String.format("%s: %s", clone.getClass(), clone));
	}
}
