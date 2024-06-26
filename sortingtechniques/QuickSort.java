package sortingtechniques;

public class QuickSort {
	public static void quickSort(int[] nums, int start, int end) {
		int i = start, j = end, pivot;
		while (i < j) {
			pivot = end; // assign pivot...
			while (nums[i] < nums[pivot]) {
				i++;
			}

			if (i < j) // perform swapping if required...
			{
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		if (j > start) {
			quickSort(nums, start, end - 1); // recursive call until we reach start...
		}
	}

	public static void main(String[] args) {
		int[] nums = { 10, 50, 70, 80, 20, 90, 100, 40, 60, 30 };
		// call the sorting method
		quickSort(nums, 0, nums.length - 1);
		System.out.println("Array After Sorting:");
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

}
