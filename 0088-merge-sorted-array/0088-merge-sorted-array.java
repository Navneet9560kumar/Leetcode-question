class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {

        int[] res = new int[m + n];
        int i = 0, j = 0, idx = 0;

        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                res[idx++] = arr1[i++];
            } else {
                res[idx++] = arr2[j++];
            }
        }

        while (i < m) {
            res[idx++] = arr1[i++];
        }

        while (j < n) {
            res[idx++] = arr2[j++];
        }

        // copy back to arr1
        for (int k = 0; k < m + n; k++) {
            arr1[k] = res[k];
        }
    }
}
