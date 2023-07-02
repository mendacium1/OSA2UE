package basic;

public class MoreSophisticated implements Cloneable {

	private String value;

	public MoreSophisticated(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public MoreSophisticated clone() {
		try {
			return (MoreSophisticated) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e);
		}
	}

	public static void main(String[] args) {
		MoreSophisticated ordinary = new MoreSophisticated("test");
		MoreSophisticated clone = ordinary.clone();

		System.out.println(String.format("%s: %s", ordinary.getClass(), ordinary));
		System.out.println(String.format("%s: %s", clone.getClass(), clone));
	}
}
