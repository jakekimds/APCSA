package unit1;

import java.awt.Rectangle;

public class ReviewEx1 {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(0, 0, 6, 7);
		Rectangle r2 = new Rectangle(0, 0, 10, 11);
		System.out.printf("r1 - W: %d, H: %d\n", r1.width, r1.height);
		System.out.printf("r2 - W: %d, H: %d\n", r2.width, r2.height);
	}
}