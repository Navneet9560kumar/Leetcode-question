class NumArray {
    static int[] arr;

    public NumArray(int[] nums) {   // <-- this is the constructor
        arr = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            arr[i] += arr[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return arr[right];
        }
        return arr[right] - arr[left - 1];
    }
}
