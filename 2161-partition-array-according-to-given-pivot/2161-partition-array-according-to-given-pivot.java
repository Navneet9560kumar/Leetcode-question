class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];

        int k = 0;

        // first pass: < pivot
        for (int num : nums) {
            if (num < pivot) {
                result[k++] = num;
            }
        }

        // second pass: == pivot
        for (int num : nums) {
            if (num == pivot) {
                result[k++] = num;
            }
        }

        // third pass: > pivot
        for (int num : nums) {
            if (num > pivot) {
                result[k++] = num;
            }
        }

        return result;
    }
}