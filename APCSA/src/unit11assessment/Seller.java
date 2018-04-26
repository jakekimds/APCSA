package unit11assessment;

import java.util.ArrayList;

public class Seller {
	private ArrayList<Category> categories;
	String name;

	public Seller(String name) {
		this.name = name;
	}

	public void addCategory(Category category) {
		categories.add(category);
	}

	public Category getCategory(String name) {
		for (int i = 0; i < categories.size(); i++) {
			if (categories.get(i).getName().equals(name)) {
				return categories.get(i);
			}
		}
		return null;
	}

	public ArrayList<Product> getProducts() {
		ArrayList<Product> out = new ArrayList<Product>();
		for (int i = 0; i < categories.size(); i++) {
			ArrayList<Product> products = categories.get(i).getProducts();
			for (int j = 0; j < products.size(); j++) {
				out.add(products.get(i));
			}
		}
		return out;
	}

	public String toString() {
		String out = "Seller: " + name + "\n";
		for (int i = 0; i < categories.size(); i++) {
			out += "\t" + categories.get(i).toString().replaceAll("\n", "\n\t") + "\n";
		}
		return out;
	}
}
