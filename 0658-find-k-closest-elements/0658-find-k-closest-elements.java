class Solution {
public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;

        // Handle edge cases where x is smaller than the smallest element
        // or larger than the largest element
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }
        if (x >= arr[n - 1]) {
            for (int i = n - k; i < n; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }

        // Perform binary search to find the closest element or insertion point
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] >= x) {
                hi = mid; // Move to the left half
            } else {
                lo = mid + 1; // Move to the right half
            }
        }

        // Use two pointers to find the k closest elements
        int i = lo - 1; // Start from the left of `lo`
        int j = lo;     // Start from `lo`
        while (k > 0) {
            if (i >= 0 && j < n) {
                // Compare the absolute differences to decide which element to pick
                int di = Math.abs(x - arr[i]);
                int dj = Math.abs(x - arr[j]);
                if (di <= dj) {
                    ans.add(arr[i--]); // Pick from the left
                } else {
                    ans.add(arr[j++]); // Pick from the right
                }
            } else if (i >= 0) {
                // Only left side is valid
                ans.add(arr[i--]);
            } else {
                // Only right side is valid
                ans.add(arr[j++]);
            }
            k--;
        }

        // Sort the result since the question requires elements in ascending order
        Collections.sort(ans);
        return ans;
    }
}