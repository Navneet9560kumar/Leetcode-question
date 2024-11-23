class Solution {
    public int[] searchRange(int[] arr, int target) {
        int n = arr.length;
        int[] ans = {-1, -1}; // Default values if the target is not found

        // Find the first position of the target
        ans[0] = findPosition(arr, target, true);

        // Find the last position of the target
        ans[1] = findPosition(arr, target, false);

        return ans;
    }

    // Helper function to find either first or last position
    private int findPosition(int[] arr, int target, boolean findFirst) {
        int lo = 0, hi = arr.length - 1, position = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == target) {
                position = mid; // Record the position
                if (findFirst) {
                    hi = mid - 1; // Continue searching in the left half
                } else {
                    lo = mid + 1; // Continue searching in the right half
                }
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return position;
    }
}
