class Solution {
    public int numberOfSpecialChars(String word) {

        int[] lastSmall = new int[26];
        int[] firstBig = new int[26];

        // initialize
        for (int i = 0; i < 26; i++) {
            lastSmall[i] = -1;
            firstBig[i] = -1;
        }

        // traverse string
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {

                lastSmall[ch - 'a'] = i;

            } else {

                int idx = ch - 'A';

                if (firstBig[idx] == -1) {
                    firstBig[idx] = i;
                }
            }
        }

        int count = 0;

        // check condition
        for (int i = 0; i < 26; i++) {

            if (lastSmall[i] != -1 &&
                firstBig[i] != -1 &&
                lastSmall[i] < firstBig[i]) {

                count++;
            }
        }

        return count;
    }
}