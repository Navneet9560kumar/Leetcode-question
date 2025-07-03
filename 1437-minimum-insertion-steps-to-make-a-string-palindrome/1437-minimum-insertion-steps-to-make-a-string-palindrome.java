class Solution {
      public static int minDeletionsToPalindrome(String s) {
        int lps = longestPalindromeSubseq(s);
        return s.length() - lps;
    }

    // Longest Palindromic Subsequence using LCS logic
    public static int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        // Standard LCS between s and reversed s
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][n];  // Length of Longest Palindromic Subsequence
    }
    public int minInsertions(String s) {
        return s.length()-longestPalindromeSubseq(s);
    }
}