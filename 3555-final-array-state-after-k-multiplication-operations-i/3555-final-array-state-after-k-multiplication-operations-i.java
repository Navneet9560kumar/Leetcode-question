class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;

        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Step 1: Find the minimum element and its index
            int minIndex = 0;
            for (int j = 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // Step 2: Multiply the minimum element by the multiplier
            nums[minIndex] *= multiplier;
        }

        // Return the modified array
        return nums;
    }
}
