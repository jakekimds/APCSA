package unit11assessment;

public class Product {
	private String name;
	private float price;

	public Product(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setPrice(int newPrice) {
		price = newPrice;
	}

	public String toString() {
		String out = "";
		out += String.format(" - %.2f - \t %s", price, name);
		return out;
	}
}
