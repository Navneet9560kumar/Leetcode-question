class Solution {
    public static long coinCount(int i, int[] coins, int amount,  int[][]dp) {
            if (i == coins.length) {
                  if (amount == 0)
                        return 0;
                  return Integer.MAX_VALUE;
            }
            if(dp[i][amount] != -1) return dp[i][amount];
            long skip = coinCount(i + 1, coins, amount,dp);
            if (amount - coins[i] < 0)
                  return skip;
            long pick = 1 + coinCount(i, coins, amount - coins[i],dp);
            dp[i][amount] = (int) Math.min(skip, pick);
            return dp[i][amount];
      }

      public int coinChange(int[] coins, int amount) {
            int[][]dp = new int[coins.length + 1][amount + 1];
            for(int i=0; i<dp.length;i++)
                  for(int j=0;j<dp[0].length;j++) dp[i][j] =-1;

                  
            long result = coinCount(0, coins, amount,dp);
            return result == Integer.MAX_VALUE ? -1 : (int) result;
      }
}