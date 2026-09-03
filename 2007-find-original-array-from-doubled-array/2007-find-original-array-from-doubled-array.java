import java.util.*;

class Solution {
    public int[] findOriginalArray(int[] changed) {

        int n = changed.length;

        // Odd length cannot be a doubled array
        if (n % 2 != 0) {
            return new int[0];
        }

        // Sort the array
        Arrays.sort(changed);

        // Store frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : changed) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int num : changed) {

            // If this number is already completely used
            if (map.get(num) == 0) {
                continue;
            }

            int twice = 2 * num;

            // Double doesn't exist
            if (!map.containsKey(twice) || map.get(twice) == 0) {
                return new int[0];
            }

            // Add original number
            result.add(num);

            // Use num and its double
            map.put(num, map.get(num) - 1);
            map.put(twice, map.get(twice) - 1);
        }

        // Convert ArrayList<Integer> to int[]
        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}