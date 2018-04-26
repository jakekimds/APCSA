package unit7;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -
public class TriangleThree {
	private int size;
	private String letter;

	public TriangleThree() {
		setTriangle(0, "a");
	}

	public TriangleThree(int count, String let) {
		setTriangle(count, let);
	}

	public void setTriangle(int sz, String let) {
		size = sz;
		letter = let;
	}

	public String getLetter() {
		return letter;
	}

	public String toString() {
		String output = "";
		for (int i = 0; i < size; i++) {
			for (int j = size - (i + 1); j > 0; j--) {
				output += " ";
			}
			for (int k = 0; k < i + 1; k++) {
				output += letter;
			}
			output += "\n";
		}
		return output + "\n";
	}
}