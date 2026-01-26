class Solution {
    public int minimumDifference(int[] nums, int k) {
           if (k == 1) return 0;   // important edge case

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i + k - 1 < nums.length; i++) {
            int diff = nums[i + k - 1] - nums[i];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}