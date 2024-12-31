class Solution {
    public int mincostTickets(int[] days, int[] costs) {
     int maxDay = days[days.length - 1];
             int[] dp = new int[maxDay + 1];

    Set<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day);
        }
              for (int i = 1; i <= maxDay; i++) {
            if (!travelDays.contains(i)) {
            
                dp[i] = dp[i - 1];
            } else {
            
                int cost1 = dp[i - 1] + costs[0]; 
                int cost7 = dp[Math.max(0, i - 7)] + costs[1]; 
                int cost30 = dp[Math.max(0, i - 30)] + costs[2]; 

            
                dp[i] = Math.min(cost1, Math.min(cost7, cost30));
            }
        }

        return dp[maxDay];
    }
}