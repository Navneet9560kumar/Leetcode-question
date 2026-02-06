class Solution {
    public int[] constructTransformedArray(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {

            int jump = nums[i] % n;
            int newIdx = (i + jump) % n;

            if (newIdx < 0) {
                newIdx += n;
            }

            res[i] = nums[newIdx];
        }

        return res;
    }
}
