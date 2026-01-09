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

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    // helper class
    class Pair {
        TreeNode node;
        int depth;
        Pair(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }

    Pair dfs(TreeNode root) {
        if (root == null)
            return new Pair(null, 0);

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        // agar dono side ki depth same hai
        if (left.depth == right.depth) {
            return new Pair(root, left.depth + 1);
        }
        // jo side deeper hai wahi answer le jao
        if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        } else {
            return new Pair(right.node, right.depth + 1);
        }
    }
}
