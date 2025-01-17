class Solution {
    public int findLength(int[] nums1, int[] nums2) {
         int maxLength = 0;

        // Check all possible alignments of nums1 and nums2
        for (int offset = 0; offset < nums1.length; offset++) {
            maxLength = Math.max(maxLength, maxCommonLength(nums1, nums2, offset, 0));
        }
        for (int offset = 0; offset < nums2.length; offset++) {
            maxLength = Math.max(maxLength, maxCommonLength(nums1, nums2, 0, offset));
        }

        return maxLength;
    }

    private int maxCommonLength(int[] nums1, int[] nums2, int start1, int start2) {
        int length = 0;
        int maxLength = 0;

        while (start1 < nums1.length && start2 < nums2.length) {
            if (nums1[start1] == nums2[start2]) {
                length++;
                maxLength = Math.max(maxLength, length);
            } else {
                length = 0;
            }
            start1++;
            start2++;
        }

        return maxLength;
    }
}