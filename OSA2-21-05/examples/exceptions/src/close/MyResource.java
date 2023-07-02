package close;

public class MyResource implements AutoCloseable {

	public void hardWork() {
		System.out.println("Watch me doing hard work.");
	}

	@Override
	public void close() {
		System.out.println("Clean up done.");
	}

}
