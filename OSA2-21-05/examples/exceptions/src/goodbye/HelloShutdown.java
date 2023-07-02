package goodbye;

public class HelloShutdown {
	public static void main(String[] args) {
		System.out.println("Hello world");
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("Goodbye world");
			}
		});
		System.exit(0);
	}
}
