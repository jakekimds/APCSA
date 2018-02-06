package unit2;

public class Fahrenheit {
	private double fahrenheit;

	public void setFahrenheit(double fahren) {
		fahrenheit = fahren;
	}

	public double getCelsius() {
		double celsius = 0.0;
		celsius = fahrenheit - 32;
		celsius = celsius * 5 / 9;
		return celsius;
	}

	public void print() {
		// this is part of the solution
		System.out.println(fahrenheit + " degrees Fahrenheit == " + getCelsius() + " degrees Celsius");
	}
}