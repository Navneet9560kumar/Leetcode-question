class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // step 1 store 
        for(int i=0;i<nums.length;i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

           int min = Integer.MAX_VALUE;

             // Step 2: check each value

             for (List<Integer> list : map.values()) {
                 if (list.size() < 3) continue;

            // Step 3: pick consecutive 3

            for(int i=0;i<=list.size()-3;i++){
                int first = list.get(i);
                int third = list.get(i+2);
                int dist = 2 * (third - first); // optimized formula
                min = Math.min(min, dist);
            }
             }


        return min == Integer.MAX_VALUE ? -1 : min;

    }
}