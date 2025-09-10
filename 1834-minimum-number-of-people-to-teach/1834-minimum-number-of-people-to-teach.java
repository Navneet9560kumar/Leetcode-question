import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> sadUsers = new HashSet<>();

        // 1. Find all sad users (pairs who can't communicate)
        for (int[] friend : friendships) {
            int u = friend[0] - 1; // 1-based → 0-based
            int v = friend[1] - 1;

            // Put u's languages in a set
            Set<Integer> langSet = new HashSet<>();
            for (int lang : languages[u]) {
                langSet.add(lang);
            }

            // Check if v shares any language
            boolean canTalk = false;
            for (int lang : languages[v]) {
                if (langSet.contains(lang)) {
                    canTalk = true;
                    break;
                }
            }

            // If they cannot talk, mark them as sad
            if (!canTalk) {
                sadUsers.add(u);
                sadUsers.add(v);
            }
        }

        // 2. Count frequency of each language among sad users
        int[] languageCount = new int[n + 1]; // 1-indexed languages
        int mostKnownLang = 0;

        for (int user : sadUsers) {
            for (int lang : languages[user]) {
                languageCount[lang]++;
                mostKnownLang = Math.max(mostKnownLang, languageCount[lang]);
            }
        }

        // 3. Answer = sadUsers.size() - mostKnownLang
        return sadUsers.size() - mostKnownLang;
    }
}
