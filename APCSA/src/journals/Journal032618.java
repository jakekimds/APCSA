package journals;

public class Journal032618 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Animal {
	public void eat(String food) {
		System.out.println("Eating " + food);
	}

	public void walkTowards(String target) {
		System.out.println("Walking towards " + target);
	}
}

class Dog extends Animal {
	public void bark() {
		System.out.println("Woof Woof");
	}

	public void wagTail() {
		System.out.println("Wagging tail");
	}
}
