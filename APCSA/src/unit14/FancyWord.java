package unit14;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class FancyWord {
	private char[][] mat;

	public FancyWord() {

	}

	public FancyWord(String s) {
		int len = s.length();
		mat = new char[len][len];
		for (int i = 0; i < s.length(); i++) {
			int c1 = i;
			int c2 = len - i - 1;
			for (int c = 0; c < len; c++) {
				if (i == 0 || i == len - 1) {
					mat[i][c] = s.charAt(c);
				} else {
					if (c == c1 || c == c2) {
						mat[i][c] = s.charAt(c);
					} else {
						mat[i][c] = ' ';
					}
				}
			}
		}
	}

	public String toString() {
		String output = "";
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				output += mat[i][j];
			}
			output += "\n";
		}
		return output + "";
	}
}