import java.util.Arrays;

class Solution {
    public static int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] setBitIndex = new int[31];
        Arrays.fill(setBitIndex, -1);

        for (int i = n - 1; i >= 0; i--) {
            int endIndex = i;

            for (int j = 0; j < 31; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    setBitIndex[j] = i;
                } else if (setBitIndex[j] != -1) {
                    endIndex = Math.max(endIndex, setBitIndex[j]);
                }
            }

            res[i] = endIndex - i + 1;
        }

        return res;
    }
}
