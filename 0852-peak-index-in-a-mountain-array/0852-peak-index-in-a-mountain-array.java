class Solution {
    public int peakIndexInMountainArray(int[] arr) {
    int n = arr.length;
    int lo = 1, hi = n - 2;   // boundary skip

    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;

        if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
            return mid;
        }
        // Increasing slope
        else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
            lo = mid + 1;
        }
        // Decreasing slope
        else {
            hi = mid - 1;
        }
    }

    return -1;
}
}