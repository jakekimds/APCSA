package journals;

import java.util.Arrays;

//Java program to count occurrences 
//of an element

public class Journal031918 {
	public static void main(String args[]) {
		int arr[] = new int[100];

		for (int i = 0; i < 100; i++) {
			arr[i] = (int) Math.random() * 100;
		}

		Arrays.sort(arr);

		long time = System.currentTimeMillis();

		for (int i = 1; i <= 100; i++) {
			int found = Arrays.binarySearch(arr, (int) Math.random() * 100);
			System.out.println(System.currentTimeMillis() - time);
			System.out.println(found);
		}
	}
}