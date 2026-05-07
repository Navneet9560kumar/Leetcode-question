import java.util.Arrays;

class Solution {

    public static int[] square(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            nums[i] = nums[i] * nums[i];
        }

        return nums;
    }

    public int[] sortedSquares(int[] nums) {

        square(nums);

        Arrays.sort(nums);

        return nums;
    }
}