package sortingtechniques;

public class BubbleSort {
	public static void bubbleSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i]) // perform swapping if required...
				{
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { 10, 50, 70, 80, 20, 90, 100, 40, 60, 30 };
		// call the sorting method
		bubbleSort(nums);
		System.out.println("Array After Sorting:");

		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

}
