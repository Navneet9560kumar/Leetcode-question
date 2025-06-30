class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        // Frequency count
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check pairs with difference = 1
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                result = Math.max(result, map.get(key) + map.get(key + 1));
            }
        }

        return result;
    }
}
