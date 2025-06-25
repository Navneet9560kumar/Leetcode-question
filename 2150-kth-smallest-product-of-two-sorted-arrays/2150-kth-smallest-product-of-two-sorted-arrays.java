class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long min1 = nums1[0];
        long max1 = nums1[nums1.length - 1];
        long min2 = nums2[0];
        long max2 = nums2[nums2.length - 1];

        long left = Math.min(Math.min(min1 * min2, min1 * max2), Math.min(max1 * min2, max1 * max2));
        long right = Math.max(Math.max(min1 * min2, min1 * max2), Math.max(max1 * min2, max1 * max2));

        while (left < right) { 
            long mid = left + (right - left) / 2;
            if (count_smaller_or_equal(mid, nums1, nums2) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; 
    }

    public long count_smaller_or_equal(long mid, int[] nums1, int[] nums2) {
        long count = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                if (mid >= 0) {
                    count += nums2.length;
                }
            } else if (nums1[i] > 0) {
                int left = 0;
                int right = nums2.length - 1;
                while (left <= right) {
                    int middle = left + (right - left) / 2;
                    if ((double) mid / nums1[i] >= nums2[middle]) {
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                }
                count += left;
            } else {
                int left = 0;
                int right = nums2.length - 1;
                while (left <= right) {
                    int middle = left + (right - left) / 2;
                    if ((double) mid / nums1[i] <= nums2[middle]) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                }
                count += nums2.length - left;
            }
        }
        return count;
    }
}