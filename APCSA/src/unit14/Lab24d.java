package unit14;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab24d {
	public static void main(String args[]) throws IOException {
		Scanner file = new Scanner(new File("src/unit14/Lab24d.dat"));
		int num = Integer.parseInt(file.nextLine());
		for (int i = 0; i < num; i++) {
			TicTacToe game = new TicTacToe(file.nextLine());
			System.out.println(game);
		}
	}
}
