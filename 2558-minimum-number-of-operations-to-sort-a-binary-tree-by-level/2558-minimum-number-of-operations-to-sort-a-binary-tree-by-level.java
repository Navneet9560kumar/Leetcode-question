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
     public int minimumOperations(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int operations = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }

            List<Integer> sort_level = new ArrayList<>(level);
            Collections.sort(sort_level);
            Map<Integer, Integer> mp = new HashMap<>();

            for (int i = 0; i < level.size(); i++) {
                mp.put(level.get(i), i);
            }

            for (int i = 0; i < level.size(); i++) {
                while (!level.get(i).equals(sort_level.get(i))) {
                    operations++;
                    int cur = mp.get(sort_level.get(i));
                    mp.put(level.get(i), cur);
                    Collections.swap(level, i, cur);
                }
            }
        }

        return operations;
    }
}