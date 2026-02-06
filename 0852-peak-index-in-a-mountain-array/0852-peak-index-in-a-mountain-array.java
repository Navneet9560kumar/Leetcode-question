class Solution {
    public int peakIndexInMountainArray(int[] arr) {
         int  n =arr.length;
            for(int i=1;i<=n-2;i++){
                  if(arr[i]>arr[i-1]&& arr[i]>arr[i+1]){
                        return i;
                  }
            }
            return -1;
    }
}