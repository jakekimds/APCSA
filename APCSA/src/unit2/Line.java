package unit2;

public class Line {
	private int xOne, yOne, xTwo, yTwo;
	private double slope;

	public Line(int x1, int y1, int x2, int y2) {
		setCoordinates(x1, y1, x2, y2);
	}

	public void setCoordinates(int x1, int y1, int x2, int y2) {
		xOne = x1;
		xTwo = x2;
		yOne = y1;
		yTwo = y2;
	}

	public void calculateSlope() {
		slope = (yOne - yTwo);
		slope /= (xOne - xTwo);
	}

	public void print() {
		System.out.printf("The slope is: %.3f\n", slope);
	}
}