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

    public int levels(TreeNode root, int[]maxDia){
        if(root==null)return 0;
        int leftLevels = levels(root.left,maxDia);
        int rightLevels = levels(root.right,maxDia);
        int dia = leftLevels + rightLevels;
        maxDia[0] = Math.max(dia,maxDia[0]);
        return 1 + Math.max(leftLevels,rightLevels);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[]maxDia = {0};
        levels(root,maxDia);
        return maxDia[0];
    }
}