class Solution {
    public int bestClosingTime(String str) {
        int n = str.length();
        
        int[] pre = new int[n + 1];   // prefix for 'N'
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1];
            if (str.charAt(i - 1) == 'N') {
                pre[i]++;
            }
        }

        int[] suf = new int[n + 1];   // suffix for 'Y'
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1];
            if (str.charAt(i) == 'Y') {
                suf[i]++;
            }
        }

        int min = Integer.MAX_VALUE;
        int ans = 0;

        for (int i = 0; i <= n; i++) {
            int penalty = pre[i] + suf[i];
            if (penalty < min) {
                min = penalty;
                ans = i;
            }
        }

        return ans;
    }
}