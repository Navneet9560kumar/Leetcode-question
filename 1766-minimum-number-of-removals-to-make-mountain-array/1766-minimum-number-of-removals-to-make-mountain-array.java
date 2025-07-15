class Solution {
    public int minimumMountainRemovals(int[] nums) {
     int n = nums.length;

        // \U0001f539 LIS from left to right
        int[] dp1 = new int[n];
        for (int i = 0; i < n; i++) {
            dp1[i] = 1;  // Minimum length is 1
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        // \U0001f539 LIS from right to left (i.e., Longest Decreasing Subsequence)
        int[] dp2 = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp2[i] = 1;  // Minimum length is 1
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        // \U0001f539 Find longest mountain
        int maxMountain = 0;
        for (int i = 1; i < n - 1; i++) {
            if (dp1[i] > 1 && dp2[i] > 1) {
                int mountainLen = dp1[i] + dp2[i] - 1;
                maxMountain = Math.max(maxMountain, mountainLen);
            }
        }

        // Total removals = total elements - longest mountain length
        return n - maxMountain;
    }
}