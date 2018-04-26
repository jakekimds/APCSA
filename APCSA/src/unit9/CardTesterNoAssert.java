package unit9;

/**
 * This is a class that tests the Card class.
 */
public class CardTesterNoAssert {
	/**
	 * The main method in this class checks the Card operations for consistency.
	 * 
	 * @param args
	 *            is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card card1 = new Card("1", "Diamonds", 1);
		System.out.println(card1.rank());
		System.out.println(card1.suit());
		System.out.println(card1.pointValue());
		System.out.println(card1.matches(new Card("1", "Diamonds", 1)));
		System.out.println(card1);
		System.out.println();
		Card card2 = new Card("9", "Hearts", 16);
		System.out.println(card2.rank());
		System.out.println(card2.suit());
		System.out.println(card2.pointValue());
		System.out.println(card2.matches(new Card("4", "Diamonds", 16)));
		System.out.println(card2);
		System.out.println();
		Card card3 = new Card("K", "Spades", 45);
		System.out.println(card3.rank());
		System.out.println(card3.suit());
		System.out.println(card3.pointValue());
		System.out.println(card3.matches(new Card("Q", "Hearts", 34)));
		System.out.println(card3);
		System.out.println();
	}
}
