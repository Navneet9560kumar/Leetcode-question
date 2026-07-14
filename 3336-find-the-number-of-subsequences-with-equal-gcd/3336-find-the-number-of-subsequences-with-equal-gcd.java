class Solution {
    int MOD = 1_000_000_007;

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;

        int maxEl = -1;
        for (int x : nums)
            maxEl = Math.max(maxEl, x);

        int[][][] dp = new int[n + 1][maxEl + 1][maxEl + 1];

        // Base case
        for (int first = 0; first <= maxEl; first++) {
            for (int second = 0; second <= maxEl; second++) {
                boolean bothNonEmpty = (first != 0 && second != 0);
                boolean gcdsMatch    = (first == second);
                dp[n][first][second] = (bothNonEmpty && gcdsMatch) ? 1 : 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int first = maxEl; first >= 0; first--) {
                for (int second = maxEl; second >= 0; second--) {

                    // Skip this index entirely
                    int skip  = dp[i + 1][first][second]; //solve(i+1, first, second);

                    // Include this index in seq1
                    int take1 = dp[i + 1][gcd(first, nums[i])][second];

                    // Include this index in seq2
                    int take2 = dp[i + 1][first][gcd(second, nums[i])];

                    dp[i][first][second] = (int)((0L + skip + take1 + take2) % MOD);
                }
            }
        }

        return dp[0][0][0]; //return solve(nums, 0, 0, 0);
    }
}

