class Solution {

    private Boolean[][] dp;

    private boolean subset(int i, int sum, int[] arr, int target) {
        if (i == arr.length) {
            return sum == target;
        }

        if (dp[i][sum] != null) return dp[i][sum];

        boolean pick = false;
        if (sum + arr[i] <= target) {
            pick = subset(i + 1, sum + arr[i], arr, target);
        }

        boolean notPick = subset(i + 1, sum, arr, target);

        return dp[i][sum] = pick || notPick;
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        if (total % 2 != 0) return false;

        int target = total / 2;
        dp = new Boolean[nums.length][target + 1];

        return subset(0, 0, nums, target);
    }
}
