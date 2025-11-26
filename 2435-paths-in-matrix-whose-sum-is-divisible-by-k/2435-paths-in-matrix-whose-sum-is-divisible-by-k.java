class Solution {

      int M = 1_000_000_007;
//     Integer[][][] t; 
//     int solve( int row, int col, int remain, int[][] grid, int k){
//         int m = grid.length;
//         int n =  grid[0].length;

//         if(row>=m || col >=n) return 0;

//         // base hai ye 
//         if(row ==m-1 && col ==n-1){
//             return ((remain + grid[row][col]) %k==0) ? 1:0;
//         }

//         if(t[row][col][remain]!= null) return t[row][col][remain];

//         int newRemain = (remain + grid[row][col])%k;

//         int down = solve(row +1, col, newRemain, grid, k);
//         int right = solve(row,col+1, newRemain, grid, k);

//         return t[row][col][remain] = (int)(((long)down+ right)%M);

// }

// this iis method number is one with the help of a //Approach-1 (Recursion + Memoization : DP On Grids)
//T.C : O(m*n*k)
//S.C : O(m*n*k)
    public int numberOfPaths(int[][] grid, int k) {
        int m =  grid.length;
        int n = grid[0].length;

        int[][][] t = new int[m+1][n+1][k+1];
        // base case 
        for(int remain =0; remain<k; remain++){
            t[m-1][n-1][remain]= ((remain+grid[m-1][n-1])% k==0)? 1: 0;
        }
         // Fill bottom-up
          for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {

                for (int remain = 0; remain < k; remain++) {

                    if (row == m - 1 && col == n - 1)
                        continue;

                    int newRemain = (remain + grid[row][col]) % k;

                    long down  = t[row + 1][col][newRemain];
                    long right = t[row][col + 1][newRemain];

                    t[row][col][remain] = (int)((down + right) % M);
                }
            }
        }
        return t[0][0][0];
    }
}