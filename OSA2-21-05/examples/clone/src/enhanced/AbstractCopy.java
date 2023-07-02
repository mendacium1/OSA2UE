package enhanced;

public abstract class AbstractCopy {

	static int counter = 0;

	int id;
	long timestamp;
	Content information;

	public AbstractCopy(Content information) {
		this.id = ++counter;
		this.timestamp = System.nanoTime();
		this.information = information;
	}

	@Override
	public String toString() {
		return String.format("%s-%d (%d): %s", getClass().getSimpleName(), id, timestamp, information.toString());
	}

}
