class Solution {
    public int largestCombination(int[] candidates) {
         int maxCount = 0; // Yeh maxCount variable ka declaration aur initialization hai

        for (int bit = 0; bit < 24; bit++) {
            int count = 0;
            
            // Har bit position par '1' hone wale numbers ko count karte hain
            for (int candidate : candidates) {
                if ((candidate & (1 << bit)) != 0) {
                    count++;
                }
            }
            
            // Max count ko update karte hain jab current count zyada ho
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
}