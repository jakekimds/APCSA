package journals;

public class Journal032118 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(largest(new int[] { 1, 4, 6, 100, 6, 3, 5, 2, 34, 56, 3, 5, 65, 2 }, 0));
	}

	public static int largest(int[] arr, int start) {
		if (start >= arr.length - 1) {
			return arr[arr.length - 1];
		}
		int prev = largest(arr, start + 1);
		if (arr[start] > prev) {
			return arr[start];
		}
		return prev;
	}

}
