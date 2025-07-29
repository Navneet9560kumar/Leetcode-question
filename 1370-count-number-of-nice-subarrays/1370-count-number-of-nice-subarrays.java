class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        int i = 0, j = 0, a = 0, b = 0, n = arr.length, k2 = 0;
        int count = 0;

        // Move i to first odd number
        while (i < n && arr[i] % 2 == 0) i++;

        // Move j to a window containing first k odd numbers
        while (j < n && k2 < k) {
            if (arr[j++] % 2 != 0) k2++;
        }

        // If we couldn't find k odd numbers, return 0
        if (k2 < k) return 0;

        j--; // Move back to the last odd
        b = j + 1;

        // Move b forward to include all trailing even numbers
        while (b < n && arr[b] % 2 == 0) b++;
        b--; // b is now last index of that window

        while (b < n) {
            count += (i - a + 1) * (b - j + 1);

            // Move i to next odd
            a = i + 1;
            i++;
            while (i < n && arr[i] % 2 == 0) i++;

            // Move j to next odd (past current j)
            j = b + 1;
            k2 = 0;
            while (j < n && k2 < 1) {
                if (arr[j++] % 2 != 0) k2++;
            }
            if (k2 < 1) break;
            j--;

            // Move b forward to include all trailing evens after new j
            b = j + 1;
            while (b < n && arr[b] % 2 == 0) b++;
            b--;
        }

        return count;
    }
}
