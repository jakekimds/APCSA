package journals;

public class Journal022118 {
	public static void main(String[] args) {
		java.util.Scanner key = new java.util.Scanner(System.in);
		while (true) {
			System.out.print(isPalindrome(key.nextInt()));
		}
		// key.close();
	}

	public static int reverse(int number) {
		int reversed = 0;
		while (number > 0) {
			reversed = reversed * 10 + number % 10;
			number /= 10;
		}
		return reversed;
	}

	public static boolean isPalindrome(int number) {
		if (reverse(number) == number) {
			return true;
		} else {
			return false;
		}
	}
}
