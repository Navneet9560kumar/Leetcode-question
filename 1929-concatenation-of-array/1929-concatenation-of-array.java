class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];       // first copy
            ans[i + n] = nums[i];   // second copy
        }

        return ans;
    }
}