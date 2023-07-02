package cards;

public class Main {

	public static void main(String[] args) {
		Card aceOfSpades = new Card(Suit.SPADE, Kind.ACE);
		System.out.println(aceOfSpades);

		Card nineOfDiamonds = new Card(Suit.DIAMOND, Kind.N9);
		System.out.println(nineOfDiamonds);

		System.out.println(compareCards(aceOfSpades, nineOfDiamonds));
	}

	private static String compareCards(Card card, Card otherCard) {
		int result = card.compareTo(otherCard);
		if (result > 0) {
			return card + " has a higher value than " + otherCard;
		} else if (result == 0) {
			return card + " and " + otherCard + " are equal";
		} else {
			return otherCard + " has a higher value than " + card;
		}
	}
}
