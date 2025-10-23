/**
 * Definition for a binary tree TreeNode.
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
    public TreeNode helper(int[] preorder, int[] inorder, int prelo, int prehi, int inlo, int inhi) {
        if (prelo > prehi || inlo > inhi) return null;

        TreeNode root = new TreeNode(preorder[prelo]);

        // Find the root index in inorder array
        int idx = inlo;
        while (idx <= inhi && inorder[idx] != root.val) {
            idx++;
        }

        // Number of TreeNodes in left subtree
        int leftSize = idx - inlo;

        // Recursive construction
        root.left = helper(preorder, inorder, prelo + 1, prelo + leftSize, inlo, idx - 1);
        root.right = helper(preorder, inorder, prelo + leftSize + 1, prehi, idx + 1, inhi);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder, inorder, 0, n - 1, 0, n - 1);
    } {
        
    }
}