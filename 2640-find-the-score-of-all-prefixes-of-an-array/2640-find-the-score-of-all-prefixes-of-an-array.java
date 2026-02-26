class Solution {
 public long[] findPrefixScore(int[] nums) {
        int n= nums.length;
       long[] ans = new long[n];
        
       long maxSoFar = 0;
    long runningScore = 0;
         for (int i = 0; i < n; i++) {
        maxSoFar = Math.max(maxSoFar, nums[i]);
        long conversion = nums[i] + maxSoFar;
        runningScore += conversion;
        ans[i] = runningScore;
    }

    return ans;
      }
}