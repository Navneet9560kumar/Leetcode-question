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
   static int maxSum;
             public static int Linesum(TreeNode root){
                  if(root==null) return 0;
                  int leftLineSum =  Linesum(root.left);
                  int rightLineSum = Linesum(root.right);
                  int pathSum = root.val;
                  if(leftLineSum>0)pathSum += leftLineSum;
                  if(rightLineSum>0) pathSum +=rightLineSum;
                  maxSum = Math.max(maxSum,pathSum);
                       return root.val + Math.max(0,Math.max(leftLineSum, rightLineSum));
             }



       public static int maxPathSum(TreeNode root) {
                      maxSum =Integer.MIN_VALUE;
        Linesum(root);
        return maxSum;
    }
}