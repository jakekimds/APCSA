package journals;

import java.util.Random;

public class Journal022218 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] counts = new int[10];
		Random random = new Random();
		int randNum;
		for (int i = 0; i < 100; i++) {
			randNum = random.nextInt(10);
			counts[randNum]++;
		}
		for (int i = 0; i < 10; i++) {
			System.out.printf("Count for %d: %d\n", i, counts[i]);
		}
	}
}
