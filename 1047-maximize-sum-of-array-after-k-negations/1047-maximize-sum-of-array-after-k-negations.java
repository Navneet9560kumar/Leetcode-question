class Solution {
   public int largestSumAfterKNegations(int[] nums, int k){
        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length && nums[i] < 0 && k > 0) {
            nums[i] *= -1;
            i++;
            k--;
        }

        // If k is still odd, flip the smallest number
        Arrays.sort(nums); // Sort again to find the new smallest
        if (k % 2 == 1) {
            nums[0] *= -1;
        }

        int sum = 0;
        for (int s : nums) {
            sum += s;
        }

        return sum;
    }
}