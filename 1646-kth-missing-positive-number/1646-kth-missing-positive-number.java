class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lo=0,hi=arr.length-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            int miss = arr[mid]-(mid+1);
                if(miss<k) lo = mid +1;
                else hi =  mid -1;
        }
        return k +lo;
  }
}