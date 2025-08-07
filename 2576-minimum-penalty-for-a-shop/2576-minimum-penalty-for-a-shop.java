class Solution {
    public int bestClosingTime(String str) {
        int n = str.length();

        int[] prefixN = new int[n + 1];  // counts of 'N' up to hour i
        for (int i = 1; i <= n; i++) {
            prefixN[i] = prefixN[i - 1];
            if (str.charAt(i - 1) == 'N') prefixN[i]++;
        }

        int[] suffixY = new int[n + 1];  // counts of 'Y' from hour i to end
        for (int i = n - 1; i >= 0; i--) {
            suffixY[i] = suffixY[i + 1];
            if (str.charAt(i) == 'Y') suffixY[i]++;  // ✅ Fixed here
        }

        int minPenalty = Integer.MAX_VALUE;
        int bestHour = 0;

        for (int i = 0; i <= n; i++) {
            int penalty = prefixN[i] + suffixY[i];
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i;
            }
        }

        return bestHour;
    }
}
