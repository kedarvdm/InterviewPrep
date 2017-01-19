package arrays.onedimentional;

public class MaximumSumSubArray {

	public static void main(String args[]) {

		int nums[] = new int[] { -2, 1, 3, 4, -1, 2, 1, -5, 4 };
		// int nums[] = new int[]{-8,-7,-6};
		System.out.println(maximumSumSubArrayOld(nums));
	}

	public static int maximumSumSubArray(int nums[]) {

		if (nums.length == 0) {
			return 0;
		}

		int ans = 0;
		int sum = 0;
		int n = nums.length - 1;

		int max = Integer.MIN_VALUE;
		boolean positiveFound = false;
		for (int i = 0; i <= n; i++) {
			if (nums[i] > 0 && !positiveFound) {
				positiveFound = true;
			}

			if (nums[i] > max) {
				// Maintain a max variable
				max = nums[i];
			}

			if (sum + nums[i] > 0) {
				sum = sum + nums[i];
			} else {
				// Reset sum
				sum = 0;
			}
			ans = Math.max(ans, sum);
		}

		if (!positiveFound) {
			return max;
		}

		return ans;
	}

	public static int maximumSumSubArrayOld(int nums[]) {

		if (nums.length == 0) {
			return 0;
		}

		int ans = 0;
		int sum = 0;
		int n = nums.length - 1;

		for (int i = 0; i <= n; i++) {

			if (sum + nums[i] > 0) {
				sum = sum + nums[i];
			} else {
				// Reset sum
				sum = 0;
			}
			ans = Math.max(ans, sum);
		}

		return ans;
	}
}
