package unit2;

public class Circle {
	private double radius;
	private double area;

	public void setRadius(double rad) {
		radius = rad;
	}

	public void calculateArea() {
		area = Math.PI * radius * radius;
	}

	public void print() {
		System.out.println("The area is: " + area);
	}
}