package cafe;

public class Americano implements Coffee {

	@Override
	public void brew() {
		System.out.println("Hot water 90 ml, espresso 60 ml");
	}

}
