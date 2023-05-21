package fibonnacci;

public class FibonacciStart {

	public static void main(final String args[]) {
		int maximum = 28;
		long startnanos = 0;
		long endnanos = 0;

		for (int i = 0; i <= maximum; i++) {
			Fibonacci fib = new Fibonacci(i);
			Thread t = new Thread(fib);
			t.start();
			try {
				startnanos = System.nanoTime();
				t.join();
				endnanos = System.nanoTime();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("fib(" + i + ") = " + fib.getResult() + " (" + fib.getNrOfThreads() + ") Threads used, "
					+ ((float) (endnanos - startnanos) / 1000 / 1000) + " ms)");
		}
	}
}
