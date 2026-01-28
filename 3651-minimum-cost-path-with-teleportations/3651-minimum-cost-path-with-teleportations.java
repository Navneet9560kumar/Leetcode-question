class Solution {

    int getBestTele(int valIdx, int[][] g, int k,
            int[][] bestValue,
            Map<Integer, List<int[]>> valToCells,
            Map<Integer, Integer> valToIndex,
            List<Integer> uniqueValues,
            int[][][] dp){
            
            int best = Integer.MAX_VALUE;

            if(valIdx < 0) return best;

            if(bestValue[valIdx][k] != -1) return bestValue[valIdx][k];

            int currentVal = uniqueValues.get(valIdx);

            // process for this currentVal.. ==
            for(int [] cell : valToCells.get(currentVal)){
                int x  = cell[0];
                int y  = cell[1];

                best = Math.min(best , res(x, y, g, k-1, dp, bestValue, valToCells, valToIndex, uniqueValues));
            }

            // process for smaller values ..<..
            best = Math.min(best , 
                            getBestTele(valIdx-1, g, k, bestValue, valToCells, valToIndex, uniqueValues, dp));
                                       // valIdx - 1...means smaller values... hongi ab isme sirf..

        return bestValue[valIdx][k] = best;
    }

    int res(int i, int j, int[][] g, int k,
            int[][][] dp, int[][] bestValue,
            Map<Integer, List<int[]>> valToCells,
            Map<Integer, Integer> valToIndex,
            List<Integer> uniqueValues) {

        int n = g.length;
        int m = g[0].length;

        // Reached bottom-right
        if (i == n - 1 && j == m - 1)
            return 0;

        if (dp[i][j][k] != -1)
            return dp[i][j][k];

        int ans = Integer.MAX_VALUE;

        // Move Down
        if (i + 1 < n) {
            int val = res(i + 1, j, g, k, dp, bestValue, valToCells, valToIndex, uniqueValues);
            if (val != Integer.MAX_VALUE) {
                ans = Math.min(ans, g[i + 1][j] + val);
            }
        }

        // Move Right
        if (j + 1 < m) {
            int val = res(i, j + 1, g, k, dp, bestValue, valToCells, valToIndex, uniqueValues);
            if (val != Integer.MAX_VALUE) {
                ans = Math.min(ans, g[i][j + 1] + val);
            }
        }

        // Teleport (only if k > 0)
        if (k > 0) {
            int valIdx = valToIndex.get(g[i][j]);
            int teleCost = getBestTele(valIdx, g, k, bestValue, valToCells, valToIndex, uniqueValues, dp);
            ans = Math.min(ans, teleCost);
        }

        return dp[i][j][k] = ans;
    }

    public int minCost(int[][] g, int k) {
        int n = g.length;
        int m = g[0].length;

        Map<Integer, Integer> valToIndex = new HashMap<>();
        List<Integer> uniqueValues = new ArrayList<>();
        Map<Integer, List<int[]>> valToCells = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = g[i][j];

                // group cells by value
                valToCells.computeIfAbsent(v, x -> new ArrayList<>());
                valToCells.get(v).add(new int[] { i, j });

            }
        }

        uniqueValues = new ArrayList<>(valToCells.keySet());

        Collections.sort(uniqueValues);

        for (int i = 0; i < uniqueValues.size(); i++) {
            valToIndex.put(uniqueValues.get(i), i);
        }

        int[][][] dp = new int[n][m][k + 1];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                Arrays.fill(dp[i][j], -1);

        int[][] bestValue = new int[uniqueValues.size()][k + 1];
        for (int[] arr : bestValue)
            Arrays.fill(arr, -1);

        return res(0, 0, g, k, dp, bestValue, valToCells, valToIndex, uniqueValues);
    }

}