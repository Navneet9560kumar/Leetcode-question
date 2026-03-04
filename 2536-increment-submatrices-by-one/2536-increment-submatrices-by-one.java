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
                mat[i][c1]+=1;
                if(c2+1<n){
                   mat[i][c2 + 1] -= 1;  // FIXED
                }
            }
        }

      for(int i=0;i<n;i++){
        for(int j=1;j<n;j++){
            mat[i][j] += mat[i][j-1];
        }
      }
      return mat;
    }
}