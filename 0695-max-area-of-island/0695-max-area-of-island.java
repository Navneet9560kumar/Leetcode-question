class Solution {
    public int maxAreaOfIsland(int[][] grid) {
         int n = grid.length;
        int m = grid[0].length;
         boolean[][] vis = new boolean[n][m];
        int maxArea = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    int area = dfs(i,j,grid,vis);
                    maxArea = Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int i, int j, int[][]grid, boolean[][]vis){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;

            if (vis[i][j] || grid[i][j] == 0)
            return 0;        
            vis[i][j]=true;
            int area =1; // current cell

         area += dfs(i - 1, j, grid, vis);
        area += dfs(i + 1, j, grid, vis);
        area += dfs(i, j - 1, grid, vis);
        area += dfs(i, j + 1, grid, vis);

        return area;

    }

}