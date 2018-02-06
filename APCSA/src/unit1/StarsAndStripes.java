package unit1;

import static java.lang.System.*;

public class StarsAndStripes {
	public StarsAndStripes() {
		out.println("StarsAndStripes");
		printTwoBlankLines();
	}

	public void printTwentyStars() {
		System.out.println("********************");
	}

	public void printTwentyDashes() {
		System.out.println("--------------------");
	}

	public void printTwoBlankLines() {
		System.out.println("\n\n");
	}

	public void printASmallBox() {
		printTwentyDashes();
		printTwentyStars();
		printTwentyDashes();
		printTwentyStars();
		printTwentyDashes();
		printTwentyStars();
		printTwentyDashes();
	}

	public void printABigBox() {
		printASmallBox();
		printASmallBox();
	}
}