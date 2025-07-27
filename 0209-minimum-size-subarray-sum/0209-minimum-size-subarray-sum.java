class Solution {
public int minSubArrayLen(int target, int[] arr) {
    int n = arr.length;
    int minLen = Integer.MAX_VALUE;
    int sum = 0;
    int start = 0;

    for (int end = 0; end < n; end++) {
        sum += arr[end];

        while (sum >= target) {
            minLen = Math.min(minLen, end - start + 1);
            sum -= arr[start];
            start++;
        }
    }

    return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
}

}