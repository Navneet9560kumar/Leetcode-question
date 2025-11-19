class Solution {
    public int findFinalValue(int[] nums, int k) {
        int n = nums.length;
         boolean found = true;
        while (found){
            found = false;
             for (int i = 0; i < n; i++) {
                if (nums[i] == k) {
                    k = k * 2;  
                    found = true;
                    break;      
                }
            }
        }

        return k;
        }
    }
