import java.util.*;

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> st = new ArrayList<>();

        for (int ele : nums) {
            st.add(ele);
        }

        Collections.sort(st);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < st.size(); i++) {
            if (st.get(i) == target) {
                ans.add(i);
            }
        }

        return ans;
    }
}