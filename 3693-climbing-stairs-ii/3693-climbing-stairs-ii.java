class Solution {
    int[] memo;

    public int climbStairs(int n, int[] costs) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return solve(0, n, costs);
    }

    private int solve(int i, int n, int[] costs) {
        if (i == n)
            return 0;

        if (memo[i] != -1)
            return memo[i];

        int cost = Integer.MAX_VALUE;

        for (int jump = 1; jump <= 3; jump++) {
            int j = i + jump;

            if (j <= n) {
                int currCost = solve(j, n, costs)
                        + costs[j - 1]
                        + jump * jump;

                cost = Math.min(cost, currCost);
            }
        }

        return memo[i] = cost;
    }
}