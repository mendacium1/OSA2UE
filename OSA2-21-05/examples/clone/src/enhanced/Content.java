package enhanced;

public class Content implements Cloneable {

	public String value;

	public Content(final String value) {
		this.value = value;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return String.format("%s: %s", super.toString(), value);
	};
}
