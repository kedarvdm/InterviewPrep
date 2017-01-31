package arrays.onedimentional;

public class RemoveDuplicates {

	public static int removeDuplicatesCount(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int count = 1;
		int fast = 0;
		for (int i = 0; i < nums.length; i++) {
			if (fast >= nums.length) {
				break;
			}
			while (fast < nums.length && nums[i] == nums[fast]) {
				fast++;
			}
			if (fast < nums.length) {
				nums[i + 1] = nums[fast];
				count++;
			}
		}

		for (int i = count; i < nums.length; i++) {
			nums[i] = -1;
		}

		return count;
	}
	
	public static void removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return;
		}

		int fast = 0;
		int i = 0;
		for (i = 0; i < nums.length; i++) {
			if (fast >= nums.length) {
				break;
			}
			while (fast < nums.length && nums[i] == nums[fast]) {
				fast++;
			}
			if (fast < nums.length) {
				nums[i + 1] = nums[fast];
			}
		}

		for (int r = i; r < nums.length; r++) {
			nums[r] = -1;
		}
	}

	public static void removeDuplucatesNaive(int[] nums) {
		if (nums.length == 0) {
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i == j) {
					continue;
				}
				
				if (nums[i] != -1) {
					if (nums[i] == nums[j]) {
						nums[j] = -1;
					}
				}
			}
		}
	}

	public static void main(String args[]) {
		int nums[] = { 1, 2, 3, 4, 4, 5, 6, 7, 7, 7, 7, 8 };

		removeDuplicates(nums);
		
		int nums1[] = { 4, 1, 2, 3, 4, 5, 9, 7, 7, 6, 7, 7, 8 };
		removeDuplucatesNaive(nums1);
	}
}
