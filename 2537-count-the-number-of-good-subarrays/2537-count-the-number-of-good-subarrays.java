class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        long ans = 0;
        long pair = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < nums.length) {
            int freq = map.getOrDefault(nums[r], 0);
            pair += freq;
            map.put(nums[r], freq + 1);

            while (pair >= k) {
                ans += nums.length - r;
                int leftfreq = map.get(nums[l]);
                pair -= leftfreq - 1;
                if (leftfreq > 1) {
                    map.put(nums[l], leftfreq - 1);
                } else {
                    map.remove(nums[l]);

                }
                l++;
            }
            r++;

        }
        return ans;
    }
}