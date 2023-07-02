package cards;

public record Card(Suit suit, Kind kind) implements Comparable<Card> {

	public Card {
		if (suit == null) {
			throw new IllegalArgumentException("Suit is missing.");
		}
		if (kind == null) {
			throw new IllegalArgumentException("Kind is missing.");
		}
	}

	@Override
	public int compareTo(Card o) {
		return kind.compareTo(o.kind);
	}

}
