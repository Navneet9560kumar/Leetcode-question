class Solution {
    public int countSubmatrices(int[][] arr, int k) {
        int m = arr.length, n = arr[0].length;
        
        // prefix sum
        int[][] pre = new int[m+1][n+1];
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                pre[i][j] = arr[i-1][j-1]
                          + pre[i-1][j]
                          + pre[i][j-1]
                          - pre[i-1][j-1];
            }
        }
        
        int count = 0;
        
        // only (0,0) → (i,j)
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(pre[i][j] <= k) count++;
            }
        }
        
        return count;
    }
}