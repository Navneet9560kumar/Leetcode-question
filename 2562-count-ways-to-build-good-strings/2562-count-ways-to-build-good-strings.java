class Solution {
   public int countGoodStrings(int low, int high, int zero, int one) {
    final int MOD = 1_000_000_007;
    int[] dp = new int[high + 1];
    dp[0] = 1;

    for (int length = 1; length <= high; length++) {
        if (length >= zero) {
            dp[length] = (dp[length] + dp[length - zero]) % MOD;
        }
        if (length >= one) {
            dp[length] = (dp[length] + dp[length - one]) % MOD;
        }
    }

    int result = 0;
    for (int length = low; length <= high; length++) {
        result = (result + dp[length]) % MOD;
    }

    return result;
}
}