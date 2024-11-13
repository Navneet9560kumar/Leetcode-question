class Solution {
   public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            count += countPairs(nums, i + 1, n - 1, lower - nums[i], upper - nums[i]);
        }

        return count;
    }

    private int countPairs(int[] nums, int start, int end, int low, int high) {
        int left = start, right = end;
        int count = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < low) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int lowerIndex = left;

        left = start;
        right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= high) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int upperIndex = left;

        return upperIndex - lowerIndex;
    }
}