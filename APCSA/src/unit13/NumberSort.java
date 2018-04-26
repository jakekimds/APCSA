package unit13;
//� A+ Computer Science  -  www.apluscompsci.com

import java.util.ArrayList;

//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSort {
	//instance variables and other methods not shown
	private static int getNumDigits(int number) {
		int count = 0;
		do {
			number /= 10;
			count++;
		} while (number > 0);
		return count;
	}

	public static int[] getSortedDigitArray(int number) {
		int[] sorted = new int[getNumDigits(number)];
		int i = 0;
		do {
			sorted[i] = number % 10;
			number /= 10;
			i++;
		} while (number > 0);

		boolean isSorted = false;
		while (!isSorted) {
			isSorted = true;
			for (i = 0; i < sorted.length - 1; i++) {
				int a = sorted[i];
				int b = sorted[i + 1];
				if (a > b) {
					sorted[i] = b;
					sorted[i + 1] = a;
					isSorted = false;
				}
			}
		}
		return sorted;
	}
}