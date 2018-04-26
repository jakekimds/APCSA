package unit9;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {
	/**
	 * The main method in this class checks the Deck operations for consistency.
	 * 
	 * @param args
	 *            is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		Deck deck1 = new Deck(new String[] { "1", "2", "3" }, new String[] { "Hearts", "Diamonds", "Spades" },
				new int[] { 1, 2, 3 });
		System.out.println(deck1.isEmpty());
		System.out.println(deck1.size());
		System.out.println(deck1.deal());
		System.out.println(deck1.size());
		System.out.println(deck1);
		System.out.println();

		Deck deck2 = new Deck(new String[] { "6", "4", "7" }, new String[] {}, new int[] { 4, 5, 5 });
		System.out.println(deck2.isEmpty());
		System.out.println(deck2.size());
		System.out.println(deck2.deal());
		System.out.println(deck2.size());
		System.out.println(deck2);
		System.out.println();

		String[] fullRanks = { "Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2" };
		String[] fullSuits = { "Spades", "Hearts", "Diamonds", "Clubs" };
		int[] fullPoints = { 11, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2 };
		Deck fullDeck = new Deck(fullRanks, fullSuits, fullPoints);
		System.out.println(fullDeck);
		fullDeck.deal();
		System.out.println(fullDeck);
		fullDeck.shuffle();
		System.out.println(fullDeck);
	}
}
