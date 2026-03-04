class Solution {
   public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        for (int[] q : queries) {
            int r1 = q[0];
            int c1 = q[1];
            int r2 = q[2];
            int c2 = q[3];

            // Fill the submatrix
            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    mat[i][j] += 1;
                }
            }
        }

        return mat;

    }
}