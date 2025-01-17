class Solution {
    public int findLength(int[] nums1, int[] nums2) {
          int maxLength = 0;

        // Check all possible alignments of nums1 and nums2
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                maxLength = Math.max(maxLength, maxCommonLength(nums1, nums2, i, j));
            }
        }

        return maxLength;
    }

    private int maxCommonLength(int[] nums1, int[] nums2, int i, int j) {
        int length = 0;
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            length++;
            i++;
            j++;
        }
        return length;
    }
}