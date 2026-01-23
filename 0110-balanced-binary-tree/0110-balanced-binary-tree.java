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
    public static int levels(TreeNode root){
            if(root==null)return 0 ;
            return 1 + Math.max(levels(root.right),levels(root.left));


      }
          public boolean isBalanced(TreeNode root){
            if(root ==null ) return true;
                  int differ=  Math.abs(levels(root.left) - levels(root.right));
                  if(differ>1) return false;
                  boolean lst = isBalanced(root.left);
                  if(lst==false)return false;
                  boolean rst = isBalanced(root.right);
                  if(rst==false)return false;
                  return true;
          }
}