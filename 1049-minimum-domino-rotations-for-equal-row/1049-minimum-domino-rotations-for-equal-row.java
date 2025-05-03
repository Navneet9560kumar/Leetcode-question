class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = helper(tops[0], tops, bottoms);
        
        if (res != -1) {
            return res;
        }
        return helper(bottoms[0], tops, bottoms);
    }
    
    private int helper(int x, int[] tops, int[] bottoms) {
        int n = tops.length;
        int rotationTop = 0;
        int rotationBottom = 0;
        
        for (int i = 0; i < n; i++) {
            // if neither top nor bottom has x
            if (tops[i] != x && bottoms[i] != x) {
                return -1;
            }
            // if top is not x, we need to rotate top
            if (tops[i] != x) {
                rotationTop++;
            }
            // if bottom is not x, we need to rotate bottom
            if (bottoms[i] != x) {
                rotationBottom++;
            }
        }
        
        return Math.min(rotationTop, rotationBottom);
    }
}
