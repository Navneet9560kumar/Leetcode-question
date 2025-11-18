class Solution {
   public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
            int n = nums.length;
            for(int i=1;i<n;i++){
                  nums[i] += nums[i-1];
            }
            int[] ans = new int[queries.length];
            for(int i=0;i<queries.length;i++){
                  int lo = 0, hi = n-1;
                  while(lo<=hi){
                        int mid = lo + (hi - lo) / 2;
                        if(nums[mid]>queries[i])hi  =mid-1;
                        else{
                              ans[i]  = Math.min(queries[i], mid+1);
                              lo = mid + 1;
                        }
                  }
            
            }
            return ans;
            }
}
