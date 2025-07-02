class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n + 1][target + 1];

        // Initialize DP table with -1 (unreachable)
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 0; // Base case: 0 elements to make sum 0

        for (int i = 1; i <= n; i++) {
            int num = nums.get(i - 1);
            for (int j = 0; j <= target; j++) {
                // Exclude current number
                dp[i][j] = dp[i - 1][j];

                // Include current number if possible
                if (j >= num && dp[i - 1][j - num] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - num] + 1);
                }
            }
        }

        return dp[n][target];
    }
}
