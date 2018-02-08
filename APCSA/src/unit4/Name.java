package unit4;

import static java.lang.System.*;

public class Name {
	private String name;

	public Name() {
		setName("John Smith");
	}

	public Name(String s) {
		setName(s);
	}

	public void setName(String s) {
		name = s;
	}

	public String getFirst() {
		int ind = name.indexOf(' ');
		String first = name.substring(0, ind);
		return first;
	}

	public String getLast() {
		int ind = name.indexOf(' ');
		String last = name.substring(ind + 1, name.length());
		return last;
	}

	public String toString() {
		return name + "\n\n";
	}
}