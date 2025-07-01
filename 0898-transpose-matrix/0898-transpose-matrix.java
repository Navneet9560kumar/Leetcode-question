class Solution {
    public int[][] transpose(int[][] arr) {
        int m= arr.length;
        int n=arr[0].length;
        int [][] tranpose = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                tranpose[i][j]= arr[j][i];
           
            }

        }
        return tranpose;
    }
}