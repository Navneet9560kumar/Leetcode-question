class Solution {
    static final int MOD = 1_000_000_007;

    public int maxProductPath(int[][] arr) {
        int m = arr.length, n = arr[0].length;

        long[][] mx = new long[m][n];
        long[][] mi = new long[m][n];

        mx[0][0] = mi[0][0] = arr[0][0];

        // first row
        for (int j = 1; j < n; j++) {
            mx[0][j] = mi[0][j] = mx[0][j - 1] * arr[0][j];
        }

        // first column
        for (int i = 1; i < m; i++) {
            mx[i][0] = mi[i][0] = mx[i - 1][0] * arr[i][0];
        }

        // fill DP
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long x = arr[i][j];

                long a = mx[i - 1][j] * x;
                long b = mi[i - 1][j] * x;
                long c = mx[i][j - 1] * x;
                long d = mi[i][j - 1] * x;

                mx[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                mi[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long ans = mx[m - 1][n - 1];
        return ans < 0 ? -1 : (int)(ans % MOD);
    }
}