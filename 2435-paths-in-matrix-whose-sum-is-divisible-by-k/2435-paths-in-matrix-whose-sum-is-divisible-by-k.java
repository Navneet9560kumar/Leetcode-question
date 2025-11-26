class Solution {

      int M = 1_000_000_007;
    Integer[][][] t; 
    int solve( int row, int col, int remain, int[][] grid, int k){
        int m = grid.length;
        int n =  grid[0].length;

        if(row>=m || col >=n) return 0;

        // base hai ye 
        if(row ==m-1 && col ==n-1){
            return ((remain + grid[row][col]) %k==0) ? 1:0;
        }

        if(t[row][col][remain]!= null) return t[row][col][remain];

        int newRemain = (remain + grid[row][col])%k;

        int down = solve(row +1, col, newRemain, grid, k);
        int right = solve(row,col+1, newRemain, grid, k);

        return t[row][col][remain] = (int)(((long)down+ right)%M);





    }
    public int numberOfPaths(int[][] grid, int k) {
int m = grid.length;
        int n = grid[0].length;

        t = new Integer[m][n][k];

        return solve(0, 0, 0, grid, k);
    }
}