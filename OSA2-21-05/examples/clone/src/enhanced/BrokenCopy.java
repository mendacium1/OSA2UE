package enhanced;

public class BrokenCopy extends ManualCopy implements Cloneable {

	public BrokenCopy(String information, String additionalInformation) {
		super(information, additionalInformation);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		BrokenCopy original = new BrokenCopy("one", "two");
		Object copy = original.clone();

		System.out.println("Original: " + original);
		System.out.println("Copy:     " + copy);
	}
}
