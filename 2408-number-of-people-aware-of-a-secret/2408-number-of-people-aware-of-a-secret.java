class Solution {
    static final int M = 1_000_000_007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1]; // dp[i] = new people on day i
        dp[1] = 1; // Day 1 -> 1 person knows

        long share = 0; // running count of sharers

        for (int day = 2; day <= n; day++) {
            // Jo log aaj se share karna start karenge
            if (day - delay >= 1) {
                share = (share + dp[day - delay]) % M;
            }

            // Jo log aaj bhool gaye -> unhe sharers se hata do
            if (day - forget >= 1) {
                share = (share - dp[day - forget] + M) % M;
            }

            dp[day] = share; // Aaj ke naye log
        }

        // Answer = un logon ka sum jo abhi bhi secret yaad rakhte hain
        long ans = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            ans = (ans + dp[day]) % M;
        }

        return (int) ans;
    }
}
