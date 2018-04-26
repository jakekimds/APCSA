package unit11assessment;

import java.util.ArrayList;

public class Shop {

	private ArrayList<Seller> sellers;
	private String name;

	public Shop(String name) {
		this.name = name;
		sellers = new ArrayList<Seller>();
	}

	public String toString() {
		String out = "Shop: " + name + "\n";
		for (int i = 0; i < sellers.size(); i++) {
			out += "\t" + sellers.get(i).toString().replaceAll("\n", "\n\t") + "\n";
		}
		return out;
	}

	public static void main(String[] args) {

	}
}
