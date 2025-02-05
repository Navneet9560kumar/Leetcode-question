class Solution {
  public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) return n;

        int maxLen = 0;
        int i = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < n; j++) {
            char ch = s.charAt(j);

            if (map.containsKey(ch) && map.get(ch) >= i) {
                i = map.get(ch) + 1;
            }

            map.put(ch, j);
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}