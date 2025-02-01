class Solution {




    public boolean isArraySpecial(int[] nums) {
        int n= nums.length;
      if (nums.length <= 1) {
            return true;
        }
          for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                // If both are even or both are odd, it's not special
                return false;
            }
        }
        return true;
    }
}