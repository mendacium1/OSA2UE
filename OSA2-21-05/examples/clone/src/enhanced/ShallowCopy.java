package enhanced;

public class ShallowCopy extends AbstractCopy implements Cloneable {

	Content additionalInformation;

	public ShallowCopy(String information, String additionalInformation) {
		super(new Content(information));
		this.additionalInformation = new Content(additionalInformation);
	}

	@Override
	public String toString() {
		return super.toString() + " " + additionalInformation.toString();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		ShallowCopy original = new ShallowCopy("one", "two");
		ShallowCopy copy = (ShallowCopy) original.clone();

		System.out.println("Original: " + original);
		System.out.println("Copy:     " + copy);

		copy.information.value = "foo";

		System.out.println("Original: " + original);
		System.out.println("Copy:     " + copy);
	}
}
