class Solution {
    public int maxFreqSum(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int[] freq = new int[26];

        int maxVowel = 0, maxConsonant = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]++;

            if (vowels.contains(c)) {
                maxVowel = Math.max(maxVowel, freq[idx]);
            } else {
                maxConsonant = Math.max(maxConsonant, freq[idx]);
            }
        }

        return maxVowel + maxConsonant;
    }
}