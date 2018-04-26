package journals;

public class Journal022618 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyString1 str = new MyString1(new char[] { 'A', 'b', 'C', 'b', 'C', 'Z' });
		MyString1 str2 = new MyString1(new char[] { 'A', 'b', 'C', 'b', 'C', 'Z' });
		MyString1 str3 = new MyString1(new char[] { 'A', 'B', 'C' });
		System.out.println(str.charAt(1));
		System.out.println(str.length());
		System.out.println(str.substring(1, 5));
		System.out.println(str.toLowerCase());
		System.out.println(str.equals(str2));
		System.out.println(str.equals(str3));
		System.out.println(MyString1.valueOf(123));
	}

}

class MyString1 {
	public char[] string;

	public MyString1(char[] chars) {
		string = chars;
	}

	public char charAt(int index) {
		return string[index];
	}

	public int length() {
		return string.length;
	}

	public MyString1 substring(int begin, int end) {
		char[] output = new char[end - begin];
		for (int i = begin; i < end; i++) {
			output[i - begin] = string[i];
		}
		return new MyString1(output);
	}

	public MyString1 toLowerCase() {
		char[] output = new char[string.length];
		for (int i = 0; i < string.length; i++) {
			if (string[i] >= 'A' && string[i] <= 'Z') {
				output[i] = (char) (string[i] - 'A' + 'a');
			} else {
				output[i] = string[i];
			}
		}
		return new MyString1(output);
	}

	public boolean equals(MyString1 s) {
		boolean equal = true;
		if (s.length() != length()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != charAt(i)) {
				equal = false;
			}
		}
		return equal;
	}

	public static MyString1 valueOf(int num) {
		int digits = 0;
		for (int mag = 1; mag <= num; mag *= 10) {
			digits++;
		}
		char[] out = new char[digits];
		int i = out.length - 1;
		do {
			out[i] = (char) ('0' + (num % 10));
			num /= 10;
			i--;
		} while (num > 0);
		return new MyString1(out);
	}

	public String toString() {
		String output = "";
		for (int i = 0; i < string.length; i++) {
			output += string[i];
		}
		return output;
	}
}