class Solution {
    public long continuousSubarrays(int[] nums) {
  int n = nums.length;
        long count = 0;

        int left = 0; // Left pointer of the sliding window
        int min = nums[0]; // Minimum value in the current window
        int max = nums[0]; // Maximum value in the current window

        for (int right = 0; right < n; right++) {
            // Update min and max as the right pointer extends
            min = Math.min(min, nums[right]);
            max = Math.max(max, nums[right]);

            // Shrink the window if the condition |max - min| > 2 is violated
            while (max - min > 2) {
                left++;
                min = nums[left]; // Recalculate min
                max = nums[left];
                for (int k = left; k <= right; k++) { // Find min and max in the reduced window
                    min = Math.min(min, nums[k]);
                    max = Math.max(max, nums[k]);
                }
            }

            // Add the count of valid subarrays ending at `right`
            count += right - left + 1;
        }

        return count;
    }
 }
    
