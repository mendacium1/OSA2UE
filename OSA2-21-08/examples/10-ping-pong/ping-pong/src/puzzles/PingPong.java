package puzzles;

public class PingPong extends Thread {

	public static synchronized void main(String[] args) {

		Thread t = new PingPong();
		t.run();
		System.out.print("Ping");
	}

	static synchronized void pong() {
		System.out.print("Pong");
	}

	@Override
	public void run() {
		pong();
	}
}
