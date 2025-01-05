class Solution {
    public int[][] imageSmoother(int[][] img) {
    int m = img.length;       // Number of rows
        int n = img[0].length;    // Number of columns
        int[][] result = new int[m][n];  // Output matrix

        // Directions array to traverse 3x3 grid
        int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        // Traverse each cell in the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;  // To calculate the sum of the valid cells
                int count = 0;  // To count the number of valid cells

                // Check all 3x3 neighbors
                for (int k = 0; k < 9; k++) {
                    int ni = i + dx[k];  // Neighbor row
                    int nj = j + dy[k];  // Neighbor column

                    // Check if the neighbor is within bounds
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        sum += img[ni][nj];  // Add valid cell value to sum
                        count++;            // Increment valid cell count
                    }
                }

                // Calculate floor of average and store in result matrix
                result[i][j] = sum / count;
            }
        }

        return result;
    }
}