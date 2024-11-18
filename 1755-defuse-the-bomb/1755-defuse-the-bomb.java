class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length; // Code ka size
        int[] result = new int[n]; // Result array initialize karo

        if (k == 0) {
            // Agar k == 0 ho, sab numbers ko 0 se replace karo
            Arrays.fill(result, 0);
            return result;
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;

            if (k > 0) {
                // Agar k positive ho, next k numbers ka sum calculate karo
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n]; // Circular indexing ke liye (i + j) % n
                }
            } else {
                // Agar k negative ho, previous |k| numbers ka sum calculate karo
                for (int j = 1; j <= Math.abs(k); j++) {
                    sum += code[(i - j + n) % n]; // Circular indexing ke liye (i - j + n) % n
                }
            }

            result[i] = sum; // Sum ko result array ke ith position pe daalo
        }

        return result; // Final decrypted code return karo
    }
}