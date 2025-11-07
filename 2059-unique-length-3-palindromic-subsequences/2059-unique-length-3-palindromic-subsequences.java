class Solution {
     public  static int countPalindromicSubsequence(String s) {
            HashMap<Character, Integer> fristmap = new HashMap<>();
            HashMap<Character, Integer> lastmap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                  char ch = s.charAt(i);
                  fristmap.putIfAbsent(ch, i);
                  lastmap.put(ch, i);
            }
            int count = 0;
            for (char ch : fristmap.keySet()) {
                int first = fristmap.get(ch);
                int last = lastmap.get(ch);
                Set<Character> set = new HashSet<>();
                  for (int i = first + 1; i < last; i++) {
                          set.add(s.charAt(i));
                  }
                  count += set.size();
            }
            return count;
       }

}