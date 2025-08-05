import java.util.Arrays;

class Solution {
    public int[] answerQueries(int[] arr, int[] queries) {
        Arrays.sort(arr); // Sort array for prefix sum and binary search

        int n = arr.length;

        // Create prefix sum array in-place
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int lo = 0, hi = n - 1, best = 0;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid] <= queries[i]) {
                    best = mid + 1; // +1 because we want the count
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            ans[i] = best;
        }

        return ans;
    }
}
