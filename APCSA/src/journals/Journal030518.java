package journals;

public class Journal030518 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MyInteger.parseInt("123"));
	}

}

class MyInteger {
	private int value;

	public MyInteger(int val) {
		value = val;
	}

	public MyInteger() {
		value = 0;
	}

	public int getValue() {
		return value;
	}

	public boolean isEven() {
		return value % 2 == 0;
	}

	public boolean isOdd() {
		return value % 2 == 1;
	}

	public boolean isPrime() {
		if (value == 2) {
			return true;
		}
		for (int i = 3; i <= Math.sqrt(value) + 1; i++) {
			if (value % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEven(MyInteger value) {
		return value.isEven();
	}

	public static boolean isOdd(MyInteger value) {
		return value.isOdd();
	}

	public static boolean isPrime(MyInteger value) {
		return value.isPrime();
	}

	public boolean equals(int val) {
		return val == value;
	}

	public boolean equals(MyInteger val) {
		return val.getValue() == value;
	}

	public static int parseInt(char[] chars) {
		int val = 0;
		for (int i = 0; i < chars.length; i++) {
			val *= 10;
			val += chars[i] - '0';
		}
		return val;
	}

	public static int parseInt(String str) {
		char[] chars = str.toCharArray();
		return parseInt(chars);
	}

}
