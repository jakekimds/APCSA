package unit9;

public class CardTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card c1 = new Card("ace", "hearts", 1);
		Card c2 = new Card("ace", "hearts", 1);
		Card c3 = new Card("ace", "hearts", 2);
		Card c4 = new Card("ace", "spades", 1);
		Card c5 = new Card("king", "hearts", 1);
		Card c6 = new Card("queen", "clubs", 3);

		assert c1.rank().equals("ace") : "Wrong rank: " + c1.rank();
		assert c1.suit().equals("hearts") : "Wrong suit: " + c1.suit();
		assert c1.pointValue() == 1 : "Wrong point value: " + c1.pointValue();
		assert c6.rank().equals("queen") : "Wrong rank: " + c6.rank();
		assert c6.suit().equals("clubs") : "Wrong suit: " + c6.suit();
		assert c6.pointValue() == 3 : "Wrong point value : " + c6.pointValue();

		assert c1.matches(c1) : "Card doesn't match itself: " + c1;
		assert c1.matches(c2) : "Duplicate cards aren't equal: " + c1;
		assert !c1.matches(c3) : "Different cards are equal: " + c1 + ", " + c3;
		assert !c1.matches(c4) : "Different cards are equal: " + c1 + ", " + c4;
		assert !c1.matches(c5) : "Different cards are equal: " + c1 + ", " + c5;
		assert !c1.matches(c6) : "Different cards are equal: " + c1 + ", " + c6;

		assert c1.toString().equals("ace of hearts (point value = 1)") : "Wrong toString: " + c1;
		assert c6.toString().equals("queen of clubs (point value = 3)") : "Wrong toString: " + c6;

		System.out.println("All tests passed!");
	}

}
