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

    public void inorder(TreeNode root, List<Integer>list){
        if(root==null) return ;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    public TreeNode buildright(List<Integer> list){
        if (list.isEmpty()) return null;
        TreeNode dummy  = new TreeNode(0);
        TreeNode curr = dummy;

        // sare ele ko right side shift
        for(int val: list){
            curr.right= new TreeNode(val);
            curr = curr.right;
            curr.left = null;// left mai null hee rahega 
        }
        return dummy.right;
    }
    public TreeNode increasingBST(TreeNode root) {
       List<Integer> list = new ArrayList<>();
        inorder(root, list); // Sorted list mil gayi
        return buildright(list);
       
   
    }
}