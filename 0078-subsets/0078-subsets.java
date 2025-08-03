class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            int total = 1<<n; // 2^n subsets
            for (int i = 0; i < total; i++) {
                  List<Integer> list = new ArrayList<>();
                  for(int  bitIdx=0;bitIdx<n; bitIdx++){
                        int mask = (1 << bitIdx);
                        if((i & mask) != 0){
                              list.add(nums[bitIdx]);
                        }
                  }
                  ans.add(list);
            }
            return ans;
    }
}