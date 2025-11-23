class Solution {
  private int atMost(int[] arr, int k) {
        int i = 0, odd = 0, count = 0;

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] % 2 != 0) odd++;

            while (odd > k) {
                if (arr[i] % 2 != 0) odd--;
                i++;
            }

            count += j - i + 1;
        }
        return count;
    }

    public int numberOfSubarrays(int[] arr, int k) {
        return atMost(arr, k) - atMost(arr, k - 1);
    }
}

