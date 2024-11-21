class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
    // Step 1: Create the grid and initialize
    char[][] grid = new char[m][n];

    // Mark guards on the grid
    for (int[] guard : guards) {
        grid[guard[0]][guard[1]] = 'G';
    }

    // Mark walls on the grid
    for (int[] wall : walls) {
        grid[wall[0]][wall[1]] = 'W';
    }

    // Step 2: Mark guarded cells
    for (int[] guard : guards) {
        markGuarded(grid, guard[0], guard[1], m, n);
    }

    // Step 3: Count unguarded cells
    int unguarded = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == '\0') { // If cell is empty and unguarded
                unguarded++;
            }
        }
    }

    return unguarded;
}

// Helper function to mark cells guarded by a specific guard
private void markGuarded(char[][] grid, int x, int y, int m, int n) {
    // Directions: up, down, left, right
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    for (int[] dir : directions) {
        int i = x + dir[0];
        int j = y + dir[1];

        // Move in the current direction
        while (i >= 0 && i < m && j >= 0 && j < n) {
            if (grid[i][j] == 'W' || grid[i][j] == 'G') {
                break; // Stop at a wall or guard
            }
            if (grid[i][j] == '\0') {
                grid[i][j] = 'X'; // Mark cell as guarded
            }
            i += dir[0];
            j += dir[1];
        }
    }
}

}