import java.util.*;

class Solution {
    public void helper(TreeNode root, int target, List<Integer> arr, List<List<Integer>> ans) {
        if (root == null) return;

        arr.add(root.val);

        if (root.left == null && root.right == null && target == root.val) {
            ans.add(new ArrayList<>(arr));
        }

        helper(root.left, target - root.val, new ArrayList<>(arr), ans);
        helper(root.right, target - root.val, new ArrayList<>(arr), ans);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }
}
