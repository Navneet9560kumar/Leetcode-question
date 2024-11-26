class Solution {
    public int smallestDivisor(int[] nums, int t) {
        int n = nums.length;

        // Find the maximum value in the array
        int mx = Integer.MIN_VALUE;
        for (int num : nums) {
            mx = Math.max(mx, num);
        }

        // Perform binary search for the smallest divisor
        int lo = 1, hi = mx, result = mx;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            // Calculate the sum for the current divisor
            int sum = 0;
            for (int num : nums) {
                sum += (num + mid - 1) / mid; // Equivalent to Math.ceil(num / mid)
            }

            if (sum <= t) {
                result = mid; // Store the current valid divisor
                hi = mid - 1; // Search for a smaller divisor
            } else {
                lo = mid + 1; // Search for a larger divisor
            }
        }

        return result;
    }
}
