package unit12.lab18e;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Word implements Comparable<Word> {
	private String word;

	public Word(String s) {
		word = s;
	}

	private int numVowels() {
		String vowels = "AEIOUaeiou";
		int vowelCount = 0;
		for (int i = 0; i < word.length(); i++) {
			if (vowels.indexOf(word.charAt(i)) != -1) {
				vowelCount++;
			}
		}
		return vowelCount;
	}

	public int compareTo(Word rhs) {
		int vowelDiff = numVowels() - rhs.numVowels();
		if (vowelDiff > 0) {
			return 1;
		}
		if (vowelDiff < 0) {
			return -1;
		}
		return word.compareToIgnoreCase(rhs.toString());
	}

	public String toString() {
		return word;
	}
}