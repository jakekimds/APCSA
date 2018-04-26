package unit5;
//� A+ Computer Science  -  www.apluscompsci.com

public class StringOddOrEven {
	private String word;

	public StringOddOrEven() {
		setString("");
	}

	public StringOddOrEven(String s) {
		setString(s);
	}

	public void setString(String s) {
		word = s;
	}

	public boolean isEven() {
		if (word.length() % 2 == 0) {
			return true;
		}
		return false;
	}

	public String toString() {
		String output = "";
		output += word + " is ";
		if (isEven()) {
			output += "even.";
		} else {
			output += "odd.";
		}
		return output;
	}
}