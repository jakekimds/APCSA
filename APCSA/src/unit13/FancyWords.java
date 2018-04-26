package unit13;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.System.*;

public class FancyWords {
	private String[] wordRay;

	public FancyWords(String sentence) {
		setWords(sentence);
	}

	public void setWords(String sentence) {
		wordRay = sentence.split(" ");
	}

	public String toString() {
		String output = "";
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < wordRay.length; i++) {
			if (wordRay[i].length() > max) {
				max = wordRay[i].length();
			}
		}
		for (int i = 0; i < max; i++) {
			for (int j = wordRay.length - 1; j >= 0; j--) {
				if (i < wordRay[j].length()) {
					output += wordRay[j].charAt(wordRay[j].length() - i - 1);
				} else {
					output += " ";
				}
			}
			output += "\n";
		}

		return output + "\n";
	}
}