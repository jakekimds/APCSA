package journals;

public class Journal022718 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[10];
		int[] newArr;
		System.out.print("Enter ten numbers: ");
		java.util.Scanner keyboard = new java.util.Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			arr[i] = keyboard.nextInt();
		}
		newArr = eliminateDuplicatesV2(arr);
		System.out.println(toString(newArr));
		keyboard.close();
	}

	public static int[] eliminateDuplicatesV2(int[] list) {
		int[] output = new int[] {};
		int[] temp;
		int i = 0;
		for (int num : list) {
			if (find(output, num) == -1) {
				temp = new int[i + 1];
				for (int c = 0; c < i; c++) {
					temp[c] = output[c];
				}
				temp[i] = num;
				i++;
				output = temp;
			}
		}
		return output;
	}

	public static int[] eliminateDuplicates(int[] list) {
		int[] output = new int[list.length];
		int i = 0;
		for (int num : list) {
			if (find(output, num) == -1 || (num == 0 && find(output, num) >= i)) {
				output[i] = num;
				i++;
			}
		}
		int[] out = new int[i];
		for (int j = 0; j < i; j++) {
			out[j] = output[j];
		}
		return out;
	}

	public static int find(int[] list, int search) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == search) {
				return i;
			}
		}
		return -1;
	}

	public static String toString(int[] arr) {
		String output = "The distinct numbers are: ";
		for (int i = 0; i < arr.length; i++) {
			output += arr[i] + " ";
		}
		return output;
	}
}
