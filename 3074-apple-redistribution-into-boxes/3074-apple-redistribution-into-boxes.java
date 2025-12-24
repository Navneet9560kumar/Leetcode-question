import java.util.Arrays;

class Solution {
    public int minimumBoxes(int[] arr, int[] cap) {

        int totalarr = 0;
        for (int a : arr) {
            totalarr += a;
        }

        Arrays.sort(cap); // ascending

        int sumcap = 0;
        int count = 0;

        // start from largest capacity
        for (int i = cap.length - 1; i >= 0; i--) {
            sumcap += cap[i];
            count++;

            if (sumcap >= totalarr) {
                return count;
            }
        }
        return count;
    }
}
