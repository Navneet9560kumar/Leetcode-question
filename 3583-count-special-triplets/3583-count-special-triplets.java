class Solution {
       static final int M = (int)1e9 + 7;
    public int specialTriplets(int[] nums) {
          Map<Integer, Integer> mpLeft = new HashMap<>();
        Map<Integer, Integer> mpRight = new HashMap<>();

        int res =0;

        for(int num: nums){
           mpRight.put(num, mpRight.getOrDefault(num, 0) + 1);
        }
        // Travessle
        for(int num: nums){
             mpRight.put(num, mpRight.get(num) - 1);

            int left  = mpLeft.getOrDefault(num * 2, 0);
            int right = mpRight.getOrDefault(num * 2, 0);

            long add = (1L * left * right) % M;
            res = (int)((res + add) % M);

            mpLeft.put(num, mpLeft.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}