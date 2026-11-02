class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        // Step 2: Median (middle element) nikalo
        int median = nums[nums.length / 2];
        
        // Step 3: Har element aur median ka absolute difference jod lo
        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        
        return moves;
    }
}
