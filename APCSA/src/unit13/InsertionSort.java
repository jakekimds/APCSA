package unit13;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class - 
//Lab  - 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static java.lang.System.*;

class InsertionSort {
	private ArrayList<String> list;

	public InsertionSort() {
		list = new ArrayList<String>();
	}

	//modfiers
	public void add(String word) {
		int searched = Collections.binarySearch(list, word);
		if (searched >= 0) {
			return;
		}
		int loc = Math.abs(searched + 1);
		list.add(loc, word);
	}

	public void remove(String word) {
		list.remove(word);
	}

	public String toString() {
		String out = "";
		for (String i : list) {
			out += i + " ";
		}
		return out;
	}
}