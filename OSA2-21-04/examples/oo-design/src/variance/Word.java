package variance;

public class Word extends Thing {

	public Word(String word) {
		super(word);
	}

	@Override
	String getThing() {
		return (String) thing;
	}
}
