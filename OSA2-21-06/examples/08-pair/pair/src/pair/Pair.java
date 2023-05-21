package pair;

public class Pair<T, U> {

	private final T key;
	private final U value;

	public Pair(T key, U value) {
		this.key = key;
		this.value = value;
	}

	public T getKey() {
		return key;
	}

	public U getValue() {
		return value;
	}

	@Override
	public boolean equals(Object other) {
		if ((other == null) || (other.getClass() != getClass())) {
			return false;
		}

		return nullSafeComponentEquals(key, ((Pair<?, ?>) other).key)
				&& nullSafeComponentEquals(value, ((Pair<?, ?>) other).value);
	}

	private boolean nullSafeComponentEquals(Object a, Object b) {
		if (a == null) {
			return a == b;
		}
		return a.equals(b);
	}

	@Override
	public int hashCode() {
		int hash = 17;
		if (key != null) {
			hash = (41 * hash) + key.hashCode();
		}
		if (value != null) {
			hash = (41 * hash) + value.hashCode();
		}
		return hash;
	}
}
