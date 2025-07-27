class Solution {
    public int numOfSubarrays(int[] arr, int k, int t) {
          int i=0,j= k-1, sum=0, count=0, n= arr.length;
            for(int  a=i;a<=j;a++){
                  sum += arr[a];
            }
            if(sum/k>=t)count++;
            i++;j++;
            while (j<n) {
                  sum = sum - arr[i-1] + arr[j];
                  if(sum/k>=t)count++;
                  i++;j++;
            }
          return count;
    }
}