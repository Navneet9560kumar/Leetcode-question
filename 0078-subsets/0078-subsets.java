import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> arr;

    public void helper(int i, int[] nums, ArrayList<Integer> ans) {
        if (i == nums.length) {
            arr.add(new ArrayList<>(ans));
            return;
        }

        helper(i + 1, nums, ans);
        ans.add(nums[i]);
        helper(i + 1, nums, ans);
        ans.remove(ans.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        arr = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        helper(0, nums, ans);
        return arr;
    }
}