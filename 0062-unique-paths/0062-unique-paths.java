class Solution {
    //  public static int uniquePaths(int m, int n) {
    //         //row:0 to m-1 | col: 0 to n-1
    //         int[][] dp = new int[m][n];
    //         for (int[] row : dp) {
    //             Arrays.fill(row, -1);
    //         }
    //         return Paths(0, 0, m, n, dp);
    // }


    //    public static int Paths(int row, int col, Integer m , Integer n,int[][] dp){
    //       if(row>=m|| col>=n) return 0;
    //       if(row==m-1 && col==n-1) return 1;
    //       if(dp[row][col]!=-1) return dp[row][col];

    //       int rightWays = Paths(row,col+1,m,n,dp);
    //       int downWay = Paths(row+1, col, m, n,dp);
    //       return dp[row][col]=rightWays+ downWay;
    //    }


       public static int uniquePaths(int m, int n) {
             int[][]dp = new int[m][n];
                        for(int i=0;i<m;i++){
                              for(int j=0;j<n;j++){
                                    if(i==0  || j==0) dp[i][j] =1;
                                    else dp[i][j] = dp[i-1][j] + dp[i][j-1];
                              }
                        }
                        return dp[m-1][n-1];
    }
 }