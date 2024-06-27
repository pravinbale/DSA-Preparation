package searchingtechniques;

public class BinarySearch {
	public static int binarySearch(int[] nums, int start, int end, int key) {
		// Pre-requesite is array must be sorted for binary search...
		if (start <= end) // go with divide and conquer approach
		{
			int mid = (start + end) / 2;
			if (key == nums[mid]) {
				return mid; // if key matches with element at mid return index
			} else if (key < nums[mid]) {
				return binarySearch(nums, start, mid - 1, key); // if key is less than element at mid of array search in
																// the left array
			} else if (key > nums[mid]) {
				return binarySearch(nums, mid + 1, end, key); // if key is less than element at mid of array search in
																// the left array

			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
		int key = 80;
		int result = binarySearch(nums, 0, nums.length - 1, key);
		if (result != -1) // display result as per return value
		{
			System.out.println("Key " + key + " found at index : " + result);
		} else {
			System.out.println("Key " + key + " not found : " + result);
		}
	}

}
