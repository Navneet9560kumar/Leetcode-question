import java.util.HashMap;

class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = -1;
        for (int key : map.keySet()) {  // ✅ Corrected here
            if (key == map.get(key)) {
                ans = Math.max(ans, key);
            }
        }

        return ans;
    }
}
