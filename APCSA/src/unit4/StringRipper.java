package unit4;

import static java.lang.System.*;

public class StringRipper {
	private String word;

	public StringRipper() {
		setString("");
	}

	public StringRipper(String s) {
		setString(s);
	}

	public void setString(String s) {
		word = s;
	}

	public String ripString(int x, int y) {
		String output = word.substring(x, y);
		return output;
	}

	public String toString() {
		return word + "\n\n";
	}
}