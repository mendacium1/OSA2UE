package performance;

public class ArithmeticExceptionPerformance {

	public static void main(String[] args) {
		ArithmeticExceptionPerformance performance = new ArithmeticExceptionPerformance();

		{
			long start = System.currentTimeMillis();
			for (int i = 0; i < 100_000_000; i++) {
				performance.divideByZeroWithCheck(4, 0);
			}
			long end = System.currentTimeMillis();
			System.out.println("divideByZeroWithCheck took " + (end - start) + "ms.");
		}

		{
			long start = System.currentTimeMillis();
			for (int i = 0; i < 100_000_000; i++) {
				performance.divideByZeroWithException(4, 0);
			}
			long end = System.currentTimeMillis();
			System.out.println("divideByZeroWithException took " + (end - start) + "ms.");
		}
	}

	private void divideByZeroWithCheck(int x, int y) {
		if (y != 0) {
			int result = x / y;
		}
	}

	private void divideByZeroWithException(int x, int y) {
		try {
			int result = x / y;
		} catch (ArithmeticException e) {
			// no op
		}
	}
}
