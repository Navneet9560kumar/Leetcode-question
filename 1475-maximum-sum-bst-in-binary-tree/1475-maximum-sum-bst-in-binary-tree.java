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
   private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        postOrder(root);
        return maxSum;
    }

    private int[] postOrder(TreeNode root) {
        if (root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);

        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            int sum = root.val + left[3] + right[3];
            maxSum = Math.max(maxSum, sum);
            int minVal = Math.min(root.val, left[1]);
            int maxVal = Math.max(root.val, right[2]);
            return new int[]{1, minVal, maxVal, sum};
        }

        return new int[]{0, 0, 0, 0};
    }
}