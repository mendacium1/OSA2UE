package enhanced;

public class ManualCopy extends AbstractCopy implements Cloneable {
	Content additionalInformation;

	public ManualCopy(String information, String additionalInformation) {
		super(new Content(information));
		this.additionalInformation = new Content(additionalInformation);
	}

	@Override
	public String toString() {
		return super.toString() + " " + additionalInformation.toString();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new ManualCopy(information.value, additionalInformation.value);
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		ManualCopy original = new ManualCopy("one", "two");
		ManualCopy copy = (ManualCopy) original.clone();

		System.out.println("Original: " + original);
		System.out.println("Copy:     " + copy);

		copy.information.value = "foo";

		System.out.println("Original: " + original);
		System.out.println("Copy:     " + copy);
	}
}
