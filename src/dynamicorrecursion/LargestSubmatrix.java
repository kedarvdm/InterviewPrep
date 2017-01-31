package dynamicorrecursion;

public class LargestSubmatrix {

	public static void main(String args[]) {
		int matrix[][] = { { 0, 0, 1, 0 }, { 0, 1, 1, 1 }, { 0, 1, 1, 1 }, { 0, 1, 1, 1 } };
		
		checkSubmatrix(matrix);
	}

	public static int checkSubmatrix(int matrix[][]) {

		int resultMatrix[][] = new int[matrix.length][matrix[0].length];

		// Copy 1st column
		for (int i = 0; i < matrix.length; i++) {
			resultMatrix[i][0] = matrix[i][0];
		}

		// Copy first row
		for (int i = 0; i < matrix[0].length; i++) {
			resultMatrix[0][i] = matrix[0][i];
		}

		// Construct remaining matrix
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1)
					resultMatrix[i][j] = min(resultMatrix[i][j - 1], resultMatrix[i - 1][j], resultMatrix[i - 1][j - 1])
							+ 1;
				else
					resultMatrix[i][j] = 0;
			}
		}

		for (int i = 0; i < resultMatrix.length; i++) {
			for (int j = 0; j < resultMatrix[0].length; j++) {
				System.out.print(resultMatrix[i][j] + " ");
			}
			System.out.println();
		}

		return 0;
	}

	public static int min(int a, int b, int c) {
		int m = a;
		if (m > b)
			m = b;
		if (m > c)
			m = c;
		return m;
	}

}
