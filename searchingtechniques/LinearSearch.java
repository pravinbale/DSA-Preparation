package searchingtechniques;

public class LinearSearch {
	public static int linearSearch(int[] nums, int key) {
		for (int i = 0; i < nums.length; i++) {
			if (key == nums[i]) // if key matches with current element return index
			{
				return i;
			}
		}
		return -1; // if key is not found return -1
	}

	public static void main(String[] args) {
		int[] nums = { 80, 20, 10, 90, 40, 30, 60, 70, 100, 50 };
		int key = 30;
		int result = linearSearch(nums, key);
		if (result != -1) // display result as per return value
		{
			System.out.println("Key " + key + " found at index : " + result);
		} else {
			System.out.println("Key " + key + " not found : " + result);
		}
	}

}
