package journals;

public class Journal032218 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = new int[6][6];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = (int) (Math.random() * 2);
			}
		}
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}

		int[] rows = new int[6];
		int[] cols = new int[6];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 1) {
					rows[i]++;
					cols[j]++;
				}
			}
		}
		System.out.print("\nRows Even: ");
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.print("\nCols Even: ");
		for (int i = 0; i < cols.length; i++) {
			if (cols[i] % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}

}
