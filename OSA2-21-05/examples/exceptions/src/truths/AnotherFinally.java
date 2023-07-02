package truths;

public class AnotherFinally {

	public static void main(String[] args) {
		System.out.println(new AnotherFinally().trueOrFalse());
	}

	private boolean trueOrFalse() {
		try {
			return false;
		} finally {
			return true;
		}
	}

}
