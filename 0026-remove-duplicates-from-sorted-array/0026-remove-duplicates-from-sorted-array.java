class Solution {
    public int removeDuplicates(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int i = 0; // unique elements ka pointer

        for (int j = 1; j < n; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }

        return i + 1; // unique elements count
    }
}