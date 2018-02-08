package unit3;

public class Distance {
	private int xOne, yOne, xTwo, yTwo;
	private double distance;

	public Distance() {
		setCoordinates(0, 0, 0, 0);
	}

	public Distance(int x1, int y1, int x2, int y2) {
		setCoordinates(x1, y1, x2, y2);
	}

	public void setCoordinates(int x1, int y1, int x2, int y2) {
		xOne = x1;
		xTwo = x2;
		yOne = y1;
		yTwo = y2;
	}

	public void calcDistance() {
		distance = Math.sqrt(Math.pow((xOne - xTwo), 2) + Math.pow((yOne - yTwo), 2));
	}

	public void print() {
		System.out.printf("distance == %.3f\n", distance);
	}
}