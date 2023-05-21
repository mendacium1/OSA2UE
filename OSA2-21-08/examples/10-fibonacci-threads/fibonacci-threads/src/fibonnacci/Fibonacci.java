package fibonnacci;

public class Fibonacci implements Runnable {

	private int result;
	private final int n;

	private int nrOfThreads = 0;

	public Fibonacci(final int n) {
		this.n = n;
	}

	public int getResult() {
		return result;
	}

	public int getNrOfThreads() {
		return nrOfThreads;
	}

	@Override
	public void run() {
		nrOfThreads++;
		if (n == 0) {
			result = 0;
		} else if (n == 1) {
			result = 1;
		} else {
			Fibonacci f1 = new Fibonacci(n - 1);
			Fibonacci f2 = new Fibonacci(n - 2);

			Thread t1 = new Thread(f1);
			Thread t2 = new Thread(f2);

			t1.start();
			t2.start();

			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			result = f1.getResult() + f2.getResult();

			nrOfThreads = nrOfThreads + f1.getNrOfThreads() + f2.getNrOfThreads();
		}
	}

}
