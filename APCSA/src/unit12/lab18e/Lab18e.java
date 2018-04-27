package unit12.lab18e;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Arrays;
import static java.lang.System.*;

public class Lab18e {
	public static void main(String args[]) throws IOException {
		Scanner file = new Scanner(new File("src/unit12/lab18e/lab18e.dat"));
		int size = file.nextInt();
		file.nextLine();
		Word[] words = new Word[size];
		for (int i = 0; i < size; i++) {
			words[i] = new Word(file.nextLine());
		}
		Arrays.sort(words);
		System.out.println(Arrays.toString(words));
	}
}