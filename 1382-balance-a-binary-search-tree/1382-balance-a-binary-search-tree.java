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
    public static void inorder(TreeNode root, List<Integer> arr) {
            if (root == null)
                  return;
            inorder(root.left, arr);
            arr.add(root.val);
            inorder(root.right, arr);
      }

      public static TreeNode buildBalanced(List<Integer> arr, int lo, int hi){
            if(lo>hi) return null;
            int mid = (lo+hi)/2;

            TreeNode root = new TreeNode(arr.get(mid));
            root.left = buildBalanced(arr, lo, mid-1);
            root.right = buildBalanced(arr, mid+1, hi);

            return root;
      } 

      public static TreeNode balanceBST(TreeNode root) {
            List<Integer> arr = new ArrayList<>();
            inorder(root, arr); // step 1
            return buildBalanced(arr, 0, arr.size() - 1); // step 2
      }

}