package unit5;

public class CharacterAnalyzer {
	private char theChar;

	public CharacterAnalyzer() {
		setChar('A');
	}

	public CharacterAnalyzer(char c) {
		setChar(c);
	}

	public void setChar(char c) {
		theChar = c;
	}

	public char getChar() {
		return theChar;
	}

	public boolean isUpper() {
		if (theChar >= 'A' && theChar <= 'Z') {
			return true;
		}
		return false;
	}

	public boolean isLower() {
		if (theChar >= 'a' && theChar <= 'z') {
			return true;
		}
		return false;
	}

	public boolean isNumber() {
		if (theChar >= '0' && theChar <= '9') {
			return true;
		}
		return false;
	}

	public int getASCII() {
		return (int) theChar;
	}

	public String toString() {
		if (isLower()) {
			return "" + getChar() + " is a lowercase character. ASCII == " + getASCII() + "\n";
		} else if (isUpper()) {
			return "" + getChar() + " is a uppercase character. ASCII == " + getASCII() + "\n";
		} else if (isNumber()) {
			return "" + getChar() + " is a number. ASCII == " + getASCII() + "\n";
		}
		return "" + getChar() + " is not a letter or a number. ASCII == " + getASCII() + "\n";
	}
}