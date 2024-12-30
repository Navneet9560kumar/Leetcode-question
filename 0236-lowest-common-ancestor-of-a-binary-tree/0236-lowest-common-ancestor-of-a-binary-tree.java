/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

       public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base condition: If root is null or matches p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursive calls for left and right subtrees
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // If both leftLCA and rightLCA are non-null, root is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise, return the non-null value
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}