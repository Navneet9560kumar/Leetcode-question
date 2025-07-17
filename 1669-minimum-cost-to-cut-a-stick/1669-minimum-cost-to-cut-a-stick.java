class Solution {
 
         public static int minCost(int n, int[] cuts) {
        int[] arr = new int[cuts.length + 2];
        int m = cuts.length;
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];  // Shift to leave space at index 0
        }
        arr[0] = 0;
        arr[m + 1] = n;
        Arrays.sort(arr);  // Sort to maintain order of cuts

        int[][] dp = new int[m + 2][m + 2];
        for (int[] row : dp) Arrays.fill(row, -1);

        return cost(1, m, arr, dp);
    }

    private static int cost(int i, int j, int[] arr, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int len = arr[j + 1] - arr[i - 1];
            int total = cost(i, k - 1, arr, dp) + cost(k + 1, j, arr, dp) + len;
            min = Math.min(min, total);
        }

        return dp[i][j] = min;
    }
}