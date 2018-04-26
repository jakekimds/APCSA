package unit6;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -
import static java.lang.System.*;
import java.lang.Math;

public class Prime {
	private int number;

	public Prime() {
		setPrime(0);
	}

	public Prime(int num) {
		setPrime(num);
	}

	public void setPrime(int num) {
		number = num;
	}

	public boolean isPrime() {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0 && number != i) {
				return false;
			}
		}
		return true;
	}

	public String toString() {
		String output = "";
		if (!isPrime()) {
			output = "not ";
		}
		output = "" + number + " is " + output + "prime";
		return output;
	}
}