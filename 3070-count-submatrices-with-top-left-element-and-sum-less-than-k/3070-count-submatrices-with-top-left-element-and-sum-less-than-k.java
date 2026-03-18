class Solution {
    public int countSubmatrices(int[][] arr, int k) {
        int m = arr.length;
        int n = arr[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i>0)arr[i][j] +=arr[i-1][j];
                if(j>0)arr[i][j] +=arr[i][j-1];
                if(i>0 && j>0)arr[i][j] -=arr[i-1][j-1];

                if(arr[i][j]<=k){
                    count++;

                } else{
                    break;
                }
            }   
    }
     return count;
}
    }