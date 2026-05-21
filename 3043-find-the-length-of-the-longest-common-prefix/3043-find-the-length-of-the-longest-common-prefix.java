import java.util.*;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        HashSet<String> set = new HashSet<>();

        // Store all prefixes from arr1
        for (int num : arr1) {
            String s = String.valueOf(num);

            String prefix = "";
            for (char ch : s.toCharArray()) {
                prefix += ch;
                set.add(prefix);
            }
        }

        int maxLen = 0;

        // Check prefixes from arr2
        for (int num : arr2) {
            String s = String.valueOf(num);

            String prefix = "";

            for (char ch : s.toCharArray()) {
                prefix += ch;

                if (set.contains(prefix)) {
                    maxLen = Math.max(maxLen, prefix.length());
                }
            }
        }

        return maxLen;
    }
}