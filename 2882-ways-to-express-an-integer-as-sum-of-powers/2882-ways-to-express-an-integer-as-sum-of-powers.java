class Solution {
     static final int M = 1000000007; 
    int[][] t;
    public int numberOfWays(int n, int x) {
       t = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                t[i][j] = -1; // fill with -1 like memset
            }
        }
        return solve(n, 1, x);
    }
    private int solve(int n, int num, int x) {
        if (n == 0) return 1; // Found valid combination
        if (n < 0) return 0;

        int currPowerValue = (int) Math.pow(num, x);
        if (currPowerValue > n) return 0;

        if (t[n][num] != -1) return t[n][num];

        int take = solve(n - currPowerValue, num + 1, x) % M;
        int skip = solve(n, num + 1, x) % M;

        return t[n][num] = (take + skip) % M;
    }
}