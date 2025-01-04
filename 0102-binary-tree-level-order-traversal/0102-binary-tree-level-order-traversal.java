/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int levels(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    public void nTHLevle(TreeNode root, int level, int lvl, List<Integer> arr) {
        if (root == null) return;
        if (level == lvl) {
            arr.add(root.val);
            return;
        }
        nTHLevle(root.left, level + 1, lvl, arr);
        nTHLevle(root.right, level + 1, lvl, arr);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int lul = levels(root);
        for (int i = 1; i <= lul; i++) {
            List<Integer> arr = new ArrayList<>();
            nTHLevle(root, 1, i, arr);
            ans.add(arr);
        }
        return ans;
    }
}