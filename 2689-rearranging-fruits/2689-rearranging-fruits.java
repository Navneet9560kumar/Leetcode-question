import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : basket1) freq.put(num, freq.getOrDefault(num, 0) + 1);
        for (int num : basket2) freq.put(num, freq.getOrDefault(num, 0) - 1);

        List<Integer> mismatch = new ArrayList<>();
        int minVal = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int val = entry.getKey();
            int count = entry.getValue();

            if (count % 2 != 0) return -1; // can't make equal baskets

            // add half the extra elements to mismatch list
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                mismatch.add(val);
            }

            minVal = Math.min(minVal, val);
        }

        // Now mismatch has total N elements to be fixed
        Collections.sort(mismatch);
        long cost = 0;
        int n = mismatch.size();

        // Swap first half with second half (simulate pairings)
        for (int i = 0; i < n / 2; i++) {
            cost += Math.min(mismatch.get(i), 2 * minVal);
        }

        return cost;
    }
}
