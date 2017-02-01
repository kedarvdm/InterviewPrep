package basics;

public class Fibonacci {

	public static int fiboRecursive(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fiboRecursive(n - 1) + fiboRecursive(n - 2);
		}
	}

	public static int fiboNonRecursive(int n) {

		if (n == 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}

		int fibo1 = 0;
		int fibo2 = 1;
		int fibo = 0;
		System.out.print("0 1 ");
		for (int i = 2; i < n; i++) {
			fibo = fibo2 + fibo1;
			System.out.print(fibo + " ");
			fibo1 = fibo2;
			fibo2 = fibo;
		}
		return fibo;
	}

	public static int fiboMemo(int n, int[] memo) {
		if (n <= 0) {
			memo[0] = 0;
			return 0;
		} else if (n == 1) {
			memo[1] = 1;
			return 1;
		} else if (memo[n] > 0) {
			return memo[n];
		}

		memo[n] = fiboMemo(n - 1, memo) + fiboMemo(n - 2, memo);
		return memo[n];

	}
	
	public static void fibo(int n) {
		int[] memo = new int[n + 1];
		int op = fiboMemo(n, memo);
		System.out.println(op);
	}

	public static void main(String[] args) {
		fibo(7);
	}
}
