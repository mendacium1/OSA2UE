package truths;

public class Finally {

	public static void main(String[] args) {
		System.out.println(new Finally().trueOrFalse());
	}

	private Boolean trueOrFalse() {
		Boolean result;
		try {
			failure();
			result = null;
		} catch (Exception e) {
			System.out.println("Exception happened.");
			result = false;
		} finally {
			System.out.println("Somethings must be done.");
			result = true;
		}
		return result;
	}

	private void failure() {
		throw new IllegalStateException();
	}
}
