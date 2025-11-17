class Solution {
    public boolean kLengthApart(int[] nums, int k) {
      int prev = -1;  // last index of 1 hai hamara 

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev != -1) {
                    // check karte hai is pehle wale mai distacnce hai kay hai 
                    if (i - prev - 1 < k) {
                        return false;
                    }
                }
                prev = i; // update last seen index of 1
            }
        }
        return true;  
    }
}