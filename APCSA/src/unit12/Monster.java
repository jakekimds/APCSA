package unit12;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Monster implements Comparable {
	private int myHeight;
	private int myWeight;
	private int myAge;

	//write a default Constructor
	public Monster() {
		setAttributes(0, 0, 0);
	}

	//write an initialization constructor with an int parameter ht

	public Monster(int ht) {
		setAttributes(ht, 0, 0);
	}

	//write an initialization constructor with int parameters ht and wt

	public Monster(int ht, int wt) {
		setAttributes(ht, wt, 0);
	}

	//write an initialization constructor with int parameters ht, wt, and age

	public Monster(int ht, int wt, int age) {
		setAttributes(ht, wt, age);
	}

	//modifiers - write set methods for height, weight, and age

	public void setAttributes(int height, int weight, int age) {
		myHeight = height;
		myWeight = weight;
		myAge = age;
	}

	//accessors - write get methods for height, weight, and age

	public void setHeight(int myHeight) {
		this.myHeight = myHeight;
	}

	public void setWeight(int myWeight) {
		this.myWeight = myWeight;
	}

	public void setAge(int myAge) {
		this.myAge = myAge;
	}

	public int getHeight() {
		return myHeight;
	}

	public int getWeight() {
		return myWeight;
	}

	public int getAge() {
		return myAge;
	}

	//creates a new copy of this Object
	public Object clone() {
		return new Monster(myHeight, myWeight, myAge);
	}

	public boolean equals(Object obj) {

		return compareTo(obj) == 0;
	}

	public int compareTo(Object obj) {
		Monster rhs = (Monster) obj;
		int weightDiff = myWeight - rhs.getWeight();
		int heightDiff = myHeight - rhs.getHeight();
		int ageDiff = myAge - rhs.getAge();
		if (heightDiff < 0) {
			return -1;
		} else if (heightDiff > 0) {
			return 1;
		} else {
			if (weightDiff < 0) {
				return -1;
			} else if (weightDiff > 0) {
				return 1;
			} else {
				if (ageDiff < 0) {
					return -1;
				} else if (ageDiff > 0) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}

	//write a toString() method
	public String toString() {
		return "" + myHeight + " " + myWeight + " " + myAge;
	}

}