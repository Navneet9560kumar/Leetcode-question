class Solution {
    public boolean canConstruct(String s, int k) {
      if (k > s.length()) return false;

        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        int oddCount = 0;
        for (int count : frequencyMap.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= k;
    }

}