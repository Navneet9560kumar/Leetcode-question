class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int count = 0;
        long value = 0;
        int power = 0;

        // Step 1: Traverse from end
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '0') {
                // Always include '0'
                count++;
                power++;
            } else {
                // Try to include '1' only if value stays <= k
                if (power < 32) { // prevent overflow
                    long add = 1L << power; // 2^power
                    if (value + add <= k) {
                        value += add;
                        count++;
                        power++;
                    }
                }
            }
        }

        return count;
    }
}
