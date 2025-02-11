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


     public int levels(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    public void perorder(TreeNode root, int level, List<Integer> ans) {
        if (root == null) return;
        
        if (level == ans.size()) {
            ans.add(root.val);  // Correct way to add elements at new level
        }

        perorder(root.right, level + 1, ans); // First right, then left for right-side view
        perorder(root.left, level + 1, ans);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        perorder(root, 0, ans);
        return ans;
    }
}