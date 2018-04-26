package unit12;
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

	public int compareTo(Word rhs) {
		int lenDiff = word.length() - rhs.toString().length();
		if (lenDiff > 0) {
			return 1;
		}
		if (lenDiff < 0) {
			return -1;
		}
		return word.compareToIgnoreCase(rhs.toString());
	}

	public String toString() {
		return word;
	}
}