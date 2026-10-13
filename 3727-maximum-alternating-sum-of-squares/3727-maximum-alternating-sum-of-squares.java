
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * arr[i];
        }

        Arrays.sort(arr);

        long small = 0;
        long large = 0;

        for (int i = 0; i < n / 2; i++) {
            small += arr[i];
        }

        for (int i = n / 2; i < n; i++) {
            large += arr[i];
        }

        return large - small;
    }
}
