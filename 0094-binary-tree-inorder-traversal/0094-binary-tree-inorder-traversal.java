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
      public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                // Left child nahi hai -> print value aur right me move karo
                ans.add(curr.val);
                curr = curr.right;
            } else {
                // Left child hai -> predecessor find karo
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    // Thread create karo
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // Thread tod do aur value add karo
                    pred.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }

}