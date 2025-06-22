class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        String[] arr = new String[(n + k - 1) / k];
        int i = 0, count = 0;

        // Add all full chunks
        while (i + k <= n) {
            arr[count++] = s.substring(i, i + k);
            i = i + k;
        }

        // If some characters are left
        if (i < n) {
            StringBuilder sb = new StringBuilder(s.substring(i, n));

            // Fill until length becomes k
            while (sb.length() < k) {
                sb.append(fill);
            }

            arr[count] = sb.toString();
        }

        return arr;
    }
}
