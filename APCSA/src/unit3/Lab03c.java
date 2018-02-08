package unit3;

public class Lab03c {
	public static void main(String[] args) {
		// add test cases
		Quadratic quad = new Quadratic();
		quad.setEquation(5, -8, 3);
		quad.calcRoots();
		quad.print();

		quad.setEquation(3, 2, -7);
		quad.calcRoots();
		quad.print();

		quad.setEquation(9, 6, 1);
		quad.calcRoots();
		quad.print();
	}
}