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
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        sumkaro(root, 0);
        return sum;
    }

    private void sumkaro(TreeNode root, int curSum) {
        if (root == null) return;

        curSum = curSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            sum += curSum;
            return;
        }

        sumkaro(root.left, curSum);
        sumkaro(root.right, curSum);
    }
}
