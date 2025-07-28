
    class Solution {
    public int maxSatisfied(int[] arr, int[] grumpy, int k) {
        int n = arr.length;
        int unsatisfied = 0;

        // Calculate initial window [0...k-1]
        for (int x = 0; x < k; x++) {
            if (grumpy[x] == 1) {
                unsatisfied += arr[x];
            }
        }

        int maxUnsatisfied = unsatisfied;
        int a = 0, b = k - 1;

        // Sliding window from k to n-1
        for (int i = 1; i + k - 1 < n; i++) {
            int j = i + k - 1;

            if (grumpy[j] == 1) unsatisfied += arr[j];
            if (grumpy[i - 1] == 1) unsatisfied -= arr[i - 1];

            if (unsatisfied > maxUnsatisfied) {
                maxUnsatisfied = unsatisfied;
                a = i;
                b = j;
            }
        }

        // Temporarily make grumpy zero in best window
        for (int x = a; x <= b; x++) {
            grumpy[x] = 0;
        }

        // Calculate total satisfied customers
        int satisfied = 0;
        for (int x = 0; x < n; x++) {
            if (grumpy[x] == 0) {
                satisfied += arr[x];
            }
        }

        return satisfied;
    }
}

