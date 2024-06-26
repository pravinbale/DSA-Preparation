package sortingtechniques;

public class SelectionSort {
	public static void selectionSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int min = nums[i];
			int index = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < min) // if we get minimum element update values...
				{
					min = nums[j];
					index = j;
				}
			}
			nums[index] = nums[i]; // perform swapping...
			nums[i] = min;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 10, 50, 70, 80, 20, 90, 100, 40, 60, 30 };
		// call the sorting method
		selectionSort(nums);
		System.out.println("Array After Sorting:");
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

}
