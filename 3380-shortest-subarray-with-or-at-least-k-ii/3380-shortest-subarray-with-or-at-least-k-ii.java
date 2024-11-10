class Solution {
     public int minimumSubarrayLength(int[] nums, int k) {
        int[] count = new int[32];
        int start = 0, end = 0, min = Integer.MAX_VALUE;

        // Iterate through each element in the array
        while (end < nums.length) {
            // Update bit count to include the current element at 'end'
            updateBits(count, nums[end], 1);

            // While the OR value meets or exceeds 'k', update min length and shift the window
            while (start <= end && getVal(count) >= k) {
                min = Math.min(min, end - start + 1);
                updateBits(count, nums[start], -1);
                start++;
            }
            end++;
        }

        // Return -1 if no valid subarray was found, otherwise return the minimum length
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // Updates the bit count array based on the current number and its effect
    public void updateBits(int count[], int num, int val) {
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) == 1)
                count[i] += val;
        }
    }

    // Computes the bitwise OR from the bit count array
    public int getVal(int[] count) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] > 0)
                ans = ans | (1 << i);
        }
        return ans;
    }
}