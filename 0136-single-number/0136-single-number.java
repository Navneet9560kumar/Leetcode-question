class Solution {
   public int singleNumber(int[] nums) {
        int n = nums.length;
        
        int maxi = Math.abs(nums[0]);
        for (int i = 1; i < n; i++) {
            maxi = Math.max(maxi, Math.abs(nums[i]));
        }
        
        int[] hash = new int[2 * maxi + 1];
        
        for (int i = 0; i < n; i++) {
            hash[nums[i] + maxi]++;
        }
        
       
        for (int i = 0; i < n; i++) {
            if (hash[nums[i] + maxi] == 1) {
                return nums[i];
            }
        }
        
        return -1; 
    }
}