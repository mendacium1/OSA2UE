package monitor.broken;

public class MarcoPolo implements Runnable {
	private final String text;
	public MarcoPolo(final String text) {
		this.text = text;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(text);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public static void main(String[] args) {
		new Thread(new MarcoPolo("Marco")).start();
		new Thread(new MarcoPolo("Polo")).start();
	}

}
