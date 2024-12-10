class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        
        // Add all elements to the set
        for (int ele : nums) {
            set.add(ele);
        }

        // Check for the first missing positive integer
        for (int num = 1; num <= n + 1; num++) {
            if (!set.contains(num)) {
                return num;
            }
        }

        // This line will never be reached because the loop ensures a return
        return -1; 
    }
}
