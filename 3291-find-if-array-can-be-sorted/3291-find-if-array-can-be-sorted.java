class Solution {
       // Helper method to check if the number of set bits is equal for two integers
    static boolean Equal(int a, int b) {
        return Integer.bitCount(a) == Integer.bitCount(b);
    }

    public static boolean canSortArray(int[] nums) {
        // Bubble sort algorithm with an additional check using the Equal helper method
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                // If the current element is greater than the next element
                if (nums[j] > nums[j + 1]) {
                    // Checking if the number of set bits is equal for the two elements
                    if (!Equal(nums[j], nums[j + 1])) {
                        // If not equal, the array cannot be sorted, thus returning false
                        return false;
                    }

                    // Swapping the elements
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        // If the loop completes, the array can be sorted, returning true
        return true;
    }
}
