class Solution {
    public int countSquares(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        int [][] rt = new int[n][m];

        int ans =0;
        for(int i=0;i<n;i++){
            rt[i][0] =matrix[i][0];
            ans+=rt[i][0];
        }
        for(int j=1;j<m;j++){
          rt[0][j] = matrix[0][j];
            ans += rt[0][j];  
        }
          for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] == 1) {
                    rt[i][j] = 1 + Math.min(Math.min(rt[i][j-1], rt[i-1][j]), rt[i-1][j-1]);
                }
                ans += rt[i][j];
            }
        }
        
        return ans;
    }
}