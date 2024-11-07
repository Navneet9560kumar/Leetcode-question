class Solution {
    public int largestCombination(int[] candidates) {
        int maxCount = 0; // Declare and initialize maxCount to track the maximum count of '1's at any bit position
        
        for (int bit = 0; bit < 24; bit++) {
            int count = 0;
            
            // Count how many numbers have a '1' at this specific bit position
            for (int candidate : candidates) {
                if ((candidate & (1 << bit)) != 0) {
                    count++;
                }
            }
            
            // Track the maximum count of numbers with '1' at any bit position
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
}