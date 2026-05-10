class Solution {
  public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        // if (n <= 1) return n;
        // int maxLen = 0;
        // int i = 0;
        // HashMap<Character, Integer> map = new HashMap<>();
        // for (int j = 0; j < n; j++) {
        //     char ch = s.charAt(j);

        //     if (map.containsKey(ch) && map.get(ch) >= i) {
        //         i = map.get(ch) + 1;
        //     }

        //     map.put(ch, j);
        //     maxLen = Math.max(maxLen, j - i + 1);
        // }

        // return maxLen;
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;

    }
}