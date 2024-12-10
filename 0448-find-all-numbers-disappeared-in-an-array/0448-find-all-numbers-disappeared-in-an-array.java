class Solution {
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int i = 0;
        
        // Place each number in its correct position
        while (i < n) {
            int ele = nums[i]; // ele should be at index ele - 1
            if (nums[i] != i + 1 && nums[i] != nums[ele - 1]) {
                swap(i, ele - 1, nums);
            } else {
                i++;
            }
        }
        
        // Find missing numbers
        List<Integer> ans = new ArrayList<>();
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) ans.add(i + 1);
        }
        
        return ans;
    }
}
