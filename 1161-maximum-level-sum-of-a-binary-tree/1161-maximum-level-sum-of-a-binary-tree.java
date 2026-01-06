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
    public int maxLevelSum(TreeNode root) {
        int ans = 1;
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        long maxSum = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            long sum = 0;
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null)q.add(node.left);
                if(node.right != null)q.add(node.right);
            }

            if(sum > maxSum){
                maxSum = sum;
                ans = level;
            }
        }


        return ans;
    }
}