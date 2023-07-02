package close;

public class Main {

	public static void main(String[] args) {
		withoutAutoclose();
		withAutoclose();
	}

	private static void withoutAutoclose() {
		MyResource resource = new MyResource();
		try {
			resource.hardWork();
		} finally {
			resource.close();
		}
	}

	private static void withAutoclose() {
		try (MyResource resource = new MyResource()) {
			resource.hardWork();
		}
	}
}
