class Solution {
    static int[] dp;

    private static int fibHelper(int n) {
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];
        return dp[n] = fibHelper(n - 1) + fibHelper(n - 2);
    }

    public static int fib(int n) {
        dp = new int[n + 1];
        return fibHelper(n);
    }
}
