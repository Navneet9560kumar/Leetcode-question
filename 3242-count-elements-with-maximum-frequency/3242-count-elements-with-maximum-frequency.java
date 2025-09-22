class Solution {
      public int maxFrequencyElements(int[] arr) {
        // unique elements
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int maxFreq = 0;
        int ans = 0;

        // har unique element ke liye frequency count
        for (int num : set) {
            int count = 0;
            for (int x : arr) {
                if (x == num) {
                    count++;
                }
            }

            if (count > maxFreq) {
                maxFreq = count;
                ans = count;
            } else if (count == maxFreq) {
                ans += count;
            }
        }

        return ans;
    }
}