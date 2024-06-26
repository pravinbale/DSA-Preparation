package sortingtechniques;

public class MergeSort {
	public static void mergeSort(int[] nums, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(nums, start, mid);
			mergeSort(nums, mid + 1, end);
			merger(nums, start, mid, end);
		}
	}

	public static void merger(int[] nums, int start, int mid, int end) {
		int[] tempArray = new int[nums.length];
		int i = start, j = mid + 1, tempIndex = start;

		while (i <= mid && j <= end) {
			if (nums[i] < nums[j]) {
				tempArray[tempIndex++] = nums[i++];
			} else {
				tempArray[tempIndex++] = nums[j++];
			}
		}
		while (i <= mid) {
			tempArray[tempIndex++] = nums[i++];
		}
		while (j <= end) {
			tempArray[tempIndex++] = nums[j++];
		}

		for (i = start; i <= end; i++) {
			nums[i] = tempArray[i];
		}
	}

	public static void main(String[] args) {
		int[] nums = { 10, 50, 70, 80, 20, 90, 100, 40, 60, 30 };
		// call the sorting method
		mergeSort(nums, 0, nums.length - 1);
		System.out.println("Array After Sorting:");
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

}
