package unit7;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class - 
//Lab  -
import static java.lang.System.*;

public class Triples {
	private int number;

	public Triples() {
		this(0);
	}

	public Triples(int num) {
		setNum(num);
	}

	public void setNum(int num) {
		number = num;
	}

	private int greatestCommonFactor(int a, int b, int c) {
		int max = a;
		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		int maxPossibleFactor = max;
		int maxCF = 1;
		for (int i = 1; i <= maxPossibleFactor; i++) {
			if (a % i == 0 && b % i == 0 && c % i == 0) {
				maxCF = i;
			}
		}
		return maxCF;
	}

	private boolean isTriple(int a, int b, int c) {
		int ca = 8, cb = 15, cc = 17;
		if (a % 2 == 0 && b % 2 == 0 || a % 2 == 1 && b % 2 == 1 || c % 2 == 0) {
			if (a == ca && cb == b && cc == c)
				System.out.println("cond 1 " + a + " " + b + " " + c);
			return false;
		}
		if (!((int) Math.pow(a, 2) + (int) Math.pow(b, 2) == (int) Math.pow(c, 2))) {
			if (a == ca && cb == b && cc == c)
				System.out.println("cond 2 " + a + " " + b + " " + c);
			return false;
		}
		if (greatestCommonFactor(a, b, c) > 1) {
			if (a == ca && cb == b && cc == c)
				System.out.println("cond 3 " + a + " " + b + " " + c);
			return false;
		}
		return true;
	}

	public String toString() {
		String output = "";
		int min = 1;
		for (int i = 1; i <= number; i += 1) {
			for (int k = i; k <= number; k += 1) {
				for (int j = 1; j <= number; j += 2) {
					if (isTriple(i, k, j)) {
						output += String.format("%d %d %d\n", i, k, j);
					}
				}
			}
		}
		return output + "\n";
	}
}