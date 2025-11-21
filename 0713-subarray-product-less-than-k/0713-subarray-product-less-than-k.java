class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k == 0)
            return 0;

        int n = nums.length;
        int i = 0;
        int j = 0;
        int pro = 1;
        int c = 0;
        while (j < n) {

            pro *= nums[j];
            if (pro >= k) {

                while (i<=j && pro >= k) {

                    pro = pro / nums[i];
                    i++;

                    if (pro < k) {
                        c += j - i + 1;
                    }
                }
            } else {

                c += j - i + 1;
            }

            j++;
        }
        return c;
    }
}