package unit3;

public class Lab03d {
	public static void main(String[] args) {
		Distance dist = new Distance();

		dist.setCoordinates(1, 1, 2, 1);
		dist.calcDistance();
		dist.print();

		dist.setCoordinates(1, 1, -2, 2);
		dist.calcDistance();
		dist.print();

		dist.setCoordinates(1, 1, 0, 0);
		dist.calcDistance();
		dist.print();
	}
}