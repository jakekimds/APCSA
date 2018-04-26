package unit13;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class Lab15d {
	public static void main(String args[]) throws IOException {
		Scanner file = new Scanner(new File("src/unit13/lab15d.dat"));
		int numOfSentences = Integer.parseInt(file.nextLine());
		for (int i = 0; i < numOfSentences; i++) {
			FancyWords fancy = new FancyWords(file.nextLine());
			System.out.print(fancy);
		}
	}
}