class Solution {
    public boolean isLess(int d, int[] arr, int t) {
    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
        // ceil(arr[i] / d)
        sum += (arr[i] + d - 1) / d;

        // optional early stop (optimization)
        if (sum > t) return false;
    }

    return true;
}
 

      public int smallestDivisor(int[] arr, int t) {
            int n = arr.length;
            int mx = Integer.MIN_VALUE;
            int d = 1;
            for (int i = 0; i < n; i++) {
                  mx = Math.max(mx, arr[i]);
            }
            int lo = 1, hi = mx;
            while (lo<=hi) {
                  int mid = lo + (hi -lo)/2;
                  if(isLess(mid,arr,t)==true){
                        d= mid;
                        hi = mid-1;

                  }else{
                        lo = mid+1;
                  }
            }
            return d;

      }

}