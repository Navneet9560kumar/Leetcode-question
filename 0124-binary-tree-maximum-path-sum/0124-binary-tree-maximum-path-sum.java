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
 public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        solve(root, res);
        return res[0];
    }

    private int solve(TreeNode root, int[] res) {
        if (root == null) return 0;

        int left = Math.max(0, solve(root.left, res));
        int right = Math.max(0, solve(root.right, res));

        int currentMaxPath = root.val + left + right;

        res[0] = Math.max(res[0], currentMaxPath);

        return root.val + Math.max(left, right);
    }
}