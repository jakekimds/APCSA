package unit8;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -
import static java.lang.System.*;

public class RomanNumeral {
	private Integer number;
	private String roman;
	private boolean containsRom;
	private final static int[] NUMBERS = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private final static String[] LETTERS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	public RomanNumeral() {
	}

	public RomanNumeral(String str) {
		setRoman(str);
	}

	public RomanNumeral(Integer orig) {
		setNumber(orig);
	}

	public void setNumber(Integer num) {
		number = num;
		containsRom = false;
	}

	public void setRoman(String rom) {
		roman = rom;
		containsRom = true;
	}

	public int getNumber() {
		String letter;
		int sum = 0;
		while (roman.length() > 0) {
			for (int i = 0; i < 13; i++) {
				letter = LETTERS[i];
				if (roman.indexOf(letter) == 0) {
					sum += NUMBERS[i];
					roman = roman.substring(letter.length());
					i = 100;
				}
			}
		}
		return sum;
	}

	public String getRoman() {
		String output = "";
		for (int i = 0; i < 13; i++) {
			while (number >= NUMBERS[i]) {
				output += LETTERS[i];
				number -= NUMBERS[i];
			}
		}
		return output;
	}

	public String toString() {
		return getRoman() + "\n";
	}
}