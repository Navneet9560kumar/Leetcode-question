class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        long result = 0;
        int bitLength = 0;
        
        for (int i = 1; i <= n; i++) {
            // If i is a power of 2, increase bit length
            if ((i & (i - 1)) == 0) {
                bitLength++;
            }
            
            // Shift result left by current bit length and add i
            result = ((result << bitLength) + i) % MOD;
        }
        
        return (int) result;
    }
}