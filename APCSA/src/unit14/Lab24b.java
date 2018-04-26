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

public class Lab24b {
	public static void main(String args[]) throws IOException {
		Scanner file = new Scanner(new File("src/unit14/lab24b.dat"));
		int size = file.nextInt();
		file.nextLine();
		for (int i = 0; i < size; i++) {
			String word = file.next();
			FancyWord fancy = new FancyWord(word);
			System.out.println(fancy);
		}
	}
}