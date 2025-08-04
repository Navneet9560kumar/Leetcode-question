class NumArray {

       private int[] arr; // class-level variable

    // Correct constructor
    public NumArray(int[] nums) {
        arr = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < nums.length; i++) {
            arr[i] += arr[i - 1]; // prefix sum
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) return arr[right];
        return arr[right] - arr[left - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */