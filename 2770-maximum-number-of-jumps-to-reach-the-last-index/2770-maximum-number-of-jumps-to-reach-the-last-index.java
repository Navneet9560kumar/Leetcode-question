class Solution {
    int n;
      public int solve(int i, int[] nums, int target, int[] t){
        if(i==n-1){
            return t[i]=0;

        }
        if(t[i] != Integer.MIN_VALUE){
            return t[i];
        }
        
        int res = Integer.MIN_VALUE;
        for( int j =i+1;j<n;j++){
            if(Math.abs(nums[i] - nums[j])<=target){
                int temp = 1+ solve(j,nums,target,t);
                res = Math.max(res,temp);
            }
        }
        
        return t[i] = res;
      }
    public int maximumJumps(int[] nums, int target) {
         n = nums.length;

        int[] t = new int[n+1];

        Arrays.fill(t, Integer.MIN_VALUE);

        int result = solve(0, nums, target, t);

        return result < 0 ? -1 : result;
    }
}