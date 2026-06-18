class Solution {
    public static void moveZeroes(int[] arr) {

    int j = 0;

    // Non-zero elements ko front me lao
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != 0) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j++;
        }
    }
}
}