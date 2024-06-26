package sortingtechniques;

public class InsertionSort {
	public static void insertionSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			int element = nums[i + 1]; // start with second element
			int j = i + 1;
			while (j >= 0 && nums[j - 1] > element) // iterate and swap until we get place for element
			{
				nums[j] = nums[j - 1];
				j--;
			}
			nums[j] = element; // place the element at right place
		}
	}

	public static void main(String[] args) {
		int[] nums = { 10, 50, 70, 80, 20, 90, 100, 40, 60, 30 };
		// call the sorting method
		insertionSort(nums);
		System.out.println("Array After Sorting:");
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

}
