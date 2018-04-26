package journals;

import java.util.Scanner;

public class Journal022018 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int decimal;
		do {
			System.out.print("Please enter an integer between 0 and 255: ");
			decimal = keyboard.nextInt();
		} while (decimal > 255 || decimal < 0);
		System.out.println(toBinary(decimal));
		keyboard.close();
	}

	public static int toBinary(int decimal) {
		int max = (int) (Math.log(decimal) / Math.log(2));
		int binary = 0;
		int bit = 0;
		for (int i = max; i >= 0; i--) {
			bit = decimal / (int) Math.pow(2, i);
			binary += Math.pow(10, i) * bit;
			decimal -= (int) Math.pow(2, i) * bit;
		}
		return binary;
	}
}
