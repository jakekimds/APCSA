package journals;

public class Journal032018 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int factorial(int base) {
		int result = 1;
		while (base > 0) {
			result *= base;
			base--;
		}
		return result;
	}

	public static int factorial2(int base) {
		if (base <= 1) {
			return 1;
		}
		return base * factorial(base - 1);
	}

}
