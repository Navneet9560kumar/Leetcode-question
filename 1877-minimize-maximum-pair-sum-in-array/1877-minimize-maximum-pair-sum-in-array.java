class Solution {

    public int minPairSum(int[] nums) {
     Arrays.sort(nums);      // Step 1: sort
        int left = 0;
        int right = nums.length - 1;
        int maxSum = 0;

        while (left < right) {
            int pairSum = nums[left] + nums[right];
            maxSum = Math.max(maxSum, pairSum);
            left++;
            right--;
        }

        return maxSum;
    }
}