class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int i = n - 1;

        for (; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }

        if (i != 0) {
            int index = i;

            for (int j = n - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    index = j;
                    break;
                }
            }

            // swap
            int temp = nums[i - 1];
            nums[i - 1] = nums[index];
            nums[index] = temp;
        }

        // reverse nums[i ... n-1]
        int left = i;
        int right = n - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}