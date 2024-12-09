class Solution {
   public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] group = new int[n];
        group[0] = 0; 
        
        for (int i = 1; i < n; i++) 
        {
            group[i] = group[i - 1];
            if ((nums[i] & 1) == (nums[i - 1] & 1)) 
            {
                group[i]++;
            }
        }

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) 
        {
            int start = queries[i][0];
            int end = queries[i][1];
            
            result[i] = (group[start] == group[end]);
        }

        return result;
    }
}