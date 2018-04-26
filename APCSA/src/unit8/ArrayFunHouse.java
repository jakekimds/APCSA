package unit8;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -
import java.lang.System;
import java.lang.Math;

public class ArrayFunHouse {
	// instance variables and constructors could be used, but are not really needed
	// getSum() will return the sum of the numbers from start to stop, not including
	// stop
	public static int getSum(int[] numArray, int start, int stop) {
		int sum = 0;
		for (int i = start; i < stop; i++) {
			sum += numArray[i];
		}
		return sum;
	}

	// getCount() will return number of times val is present
	public static int getCount(int[] numArray, int val) {
		return 0;
	}

	public static int[] removeVal(int[] numArray, int val) {
		return null;
	}
}