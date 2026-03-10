class Solution {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int majorityElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j >= 1 && nums[j] < nums[j - 1]) {
                swap(nums, j, j-1);
                j--;
            }
        }
      return nums[n / 2];
    }
}