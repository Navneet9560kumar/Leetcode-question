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
    public static List<Integer> levelSums(TreeNode root) {
    List<Integer> sums = new ArrayList<>();
    if (root == null) return sums;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
        int size = q.size();
        int sum = 0;

        for (int i = 0; i < size; i++) {
            TreeNode curr = q.poll();
            sum += curr.val;

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
        sums.add(sum);   
    }
    return sums;
}


public static int maxLevelSum(TreeNode root) {
    List<Integer> sums = levelSums(root);

    int maxSum = Integer.MIN_VALUE;
    int level = 1;
    int ansLevel = 1;

    for (int s : sums) {
        if (s > maxSum) {
            maxSum = s;
            ansLevel = level;
        }
        level++;
    }
    return ansLevel;
}
}