package custom;

public class Main {

	public static void main(String[] args) {
		Main example = new Main();
		try {
			example.success();
		} catch (CustomException e) {
			System.out.println(e.getMessage() + " - " + e.getContext());
		}
		example.failure();
	}

	public void success() throws CustomException {
		System.out.println("Starting execution.");
		throw new CustomException("Something went wrong.", "But you can fix it.");
	}

	public void failure() {
		System.out.println("Starting execution.");
		throw new CustomRuntimeException("Something went wrong.", "You didn't expect it.");
	}
}
