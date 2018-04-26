package unit7;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -
import java.util.Scanner;

public class Lab10e {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		GuessingGame game;
		char response = 'y';
		while (response == 'y') {
			game = new GuessingGame(0);
			game.playGame();
			System.out.println(game);
			System.out.print("Do you want to play again? ");
			response = keyboard.next().charAt(0);
		}
	}
}