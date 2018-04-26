package journals;

import java.util.ArrayList;

public class Journal031418 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> lst = new ArrayList<Integer>();
		lst.add(754);
		lst.add(4);
		lst.add(34);
		lst.add(64);
		lst.add(26);
		lst.add(3);
		sort(lst);
		System.out.println(lst);
	}

	public static void sort(ArrayList<Integer> list) {
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < list.size() - 1; i++) {
				int a = list.get(i);
				int b = list.get(i + 1);
				if (a > b) {
					list.set(i, b);
					list.set(i + 1, a);
					sorted = false;
				}
			}
		}
	}
}