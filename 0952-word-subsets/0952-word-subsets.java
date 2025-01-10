class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] freq = new int[26];
        for (String word : words2){
            int[] count = new int[26];
            for (char c : word.toCharArray())
                count[c - 'a']++;
            for (int i = 0; i < 26; i++)
                freq[i] = Math.max(freq[i], count[i]);
        }
        List<String> res = new ArrayList<>();
        for (String word : words1){
            int count[] = new int[26], i = 0;
            for (char c : word.toCharArray())
                count[c - 'a']++;
            for (i = 0; i < 26; i++)
                if (count[i] < freq[i])
                    break;
            if (i == 26) res.add(word);
        }
        return res;
    }
}