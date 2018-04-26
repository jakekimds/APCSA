package unit7;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -
import java.util.Scanner;

public class GuessingGame {
	private int upperBound;
	private int wrongGuesses = 0;
	private int randomNumber;

	public GuessingGame(int stop) {
		upperBound = stop;
		randomNumber = (int) (Math.random() * stop + 1);
	}

	public void playGame() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Guessing Game - how many numbers? ");
		upperBound = keyboard.nextInt();
		randomNumber = (int) (Math.random() * upperBound + 1);
		int userInput;
		boolean isPlaying = true;
		do {
			System.out.print("Enter a number between 1 and " + upperBound + " ");
			userInput = keyboard.nextInt();
			if (userInput < 1 || userInput > upperBound) {
				System.out.println("Number out of range!");
			} else {
				if (userInput == randomNumber) {
					isPlaying = false;
				} else {
					wrongGuesses++;
				}
			}
		} while (isPlaying);
	}

	public String toString() {
		String output;
		output = String.format("\nIt took %d guesses to guess %d.\n", wrongGuesses + 1, randomNumber);
		output += String.format("You guessed wrong %d percent of the time.\n\n", (wrongGuesses * 100) / upperBound);
		return output;
	}
}