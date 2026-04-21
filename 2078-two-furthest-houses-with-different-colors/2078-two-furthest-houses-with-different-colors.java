class Solution {
    public int maxDistance(int[] arr) {
        int n= arr.length;
       int res =0;
       for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(arr[i]!=arr[j]){
                res = Math.max(res,j-i);
            }
        }
       }
       return res;
    }
}