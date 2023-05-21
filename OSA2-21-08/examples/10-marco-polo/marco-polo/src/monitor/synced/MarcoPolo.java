package monitor.synced;

public class MarcoPolo implements Runnable {
	private final String text;
	private final Object monitor;

	public MarcoPolo(final String text, final Object monitor) {
		this.text = text;
		this.monitor = monitor;
	}

	@Override
	public void run() {
		synchronized (monitor) {
			while (true) {
				System.out.println(text);
				monitor.notify();
				try {
					Thread.sleep(500);
					monitor.wait();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	public static void main(String[] args) {
		Object monitor = new Object();

		new Thread(new MarcoPolo("Marco", monitor)).start();
		new Thread(new MarcoPolo("Polo", monitor)).start();
	}

}
