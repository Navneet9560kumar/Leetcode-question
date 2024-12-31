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
 public void path(TreeNode root, int currentSum, List<Integer> pathSums) {
        if (root == null) return;

        currentSum += root.val;

        // If it's a leaf node, add the current path sum to the list
        if (root.left == null && root.right == null) {
            pathSums.add(currentSum);
            return;
        }

        // Recur for left and right subtrees
        path(root.left, currentSum, pathSums);
        path(root.right, currentSum, pathSums);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        List<Integer> pathSums = new ArrayList<>();
        path(root, 0, pathSums);

        // Check if any path sum matches the target
        for (int sum : pathSums) {
            if (sum == targetSum) return true;
        }

        return false;
    }
}