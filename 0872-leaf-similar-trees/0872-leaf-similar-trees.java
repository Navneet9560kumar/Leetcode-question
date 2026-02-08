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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> listone = new ArrayList<>();
        List<Integer> listtwo = new ArrayList<>();
        lefe(root1,listone);
        lefe(root2,listtwo);
        return listone.equals(listtwo);
    }
    public void lefe(TreeNode root, List<Integer>list ){
        if(root==null)return;
        if(root.left== null && root.right==null){
            list.add(root.val);

        }
        lefe(root.left,list);
        lefe(root.right,list);
    }
}