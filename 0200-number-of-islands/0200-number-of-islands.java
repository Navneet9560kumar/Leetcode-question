class Solution {
    public static int numIslands(char[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;

    boolean[][] vis = new boolean[rows][cols];
    int count = 0;

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == '1' && !vis[i][j]) {
                dfs(i, j, grid, vis);
                count++;
            }
        }
    }
    return count;
}

public static void dfs(int i, int j, char[][] grid, boolean[][] vis) {
    int rows = grid.length;
    int cols = grid[0].length;

    vis[i][j] = true;

    if (i - 1 >= 0 && grid[i - 1][j] == '1' && !vis[i - 1][j])
        dfs(i - 1, j, grid, vis);

    if (i + 1 < rows && grid[i + 1][j] == '1' && !vis[i + 1][j])
        dfs(i + 1, j, grid, vis);

    if (j - 1 >= 0 && grid[i][j - 1] == '1' && !vis[i][j - 1])
        dfs(i, j - 1, grid, vis);

    if (j + 1 < cols && grid[i][j + 1] == '1' && !vis[i][j + 1])
        dfs(i, j + 1, grid, vis);
}

}