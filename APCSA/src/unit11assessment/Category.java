package unit11assessment;

import java.util.ArrayList;

public class Category {
	private String name;
	private ArrayList<Product> products;

	public Category(String name) {
		this.name = name;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public ArrayList<Product> getProducts() {
		ArrayList<Product> out = new ArrayList<Product>();
		for (int i = 0; i < products.size(); i++) {
			out.add(products.get(i));
		}
		return out;
	}

	public Product getProduct(String name) {
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getName().equals(name)) {
				return products.get(i);
			}
		}
		return null;
	}

	public String toString() {
		String out = "Category: " + name + "\n";
		for (int i = 0; i < products.size(); i++) {
			out += "\t - " + products.get(i).toString() + "\n";
		}
		return out;
	}

	public String getName() {
		return name;
	}

}
