package arrays.twodimentional;

public class Search2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {

		if (matrix.length == 0) {
			return false;
		}

		boolean res = false;
		int column_length = matrix[0].length - 1;
		for (int i = 0; i < matrix.length; i++) {
			if (target >= matrix[i][0] && target <= matrix[i][column_length]) {
				res = searchNumber(matrix[i], target);
				if (res) {
					return res;
				}
			}
		}
		return res;
	}

	public static boolean searchNumber(int[] row, int target) {
		int low = 0;
		int mid = 0;
		int high = row.length - 1;

		while (low <= high) {
			mid = low + ((high - low) / 2);
			if (row[mid] == target) {
				return true;
			} else if (target > row[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}

	public static void findElement(int[][] matrix, int element) {
		int rows = matrix.length;
		int columns = matrix[0].length;

		int low = 0;
		int high = rows * columns - 1;

		while (low <= high) {
			int mid = (high + low) / 2;

			int r = mid / columns;
			int c = mid % columns;

			int data = matrix[r][c];

			if (data == element) {
				System.out.println("Element found at " + r + " , " + c);
				return;
			} else if (data > element) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		System.out.println("Element not found in matrix");
	}

	public static void main(String args[]) {
		int[][] multi = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };

		System.out.println(searchMatrix(multi, 16));

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };

		findElement(matrix, 12);

	}
}
