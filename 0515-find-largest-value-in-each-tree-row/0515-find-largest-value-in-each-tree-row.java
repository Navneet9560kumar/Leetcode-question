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
 public List<Integer> largestValues(TreeNode root)
    {
        // Step 1: Handle the case of an empty tree
        if (root == null)
        {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>(); // To store largest values for each row
        Queue<TreeNode> queue = new LinkedList<>(); // For level-order traversal
        queue.offer(root); 
        
        // Step 2: Start BFS with the root node
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Step 3: Get the number of nodes in the current level
            int maxVal = Integer.MIN_VALUE; // Step 4: Initialize max value for the current level
            
            // Step 5: Traverse all nodes in the current level
            for (int i = 0; i < levelSize; i++)
            {
                TreeNode currentNode = queue.poll();

                // Step 6: Update max value with the current node's value
                maxVal = Math.max(maxVal, currentNode.val);

                // Step 7: Add left and right children to the queue for the next level
                if (currentNode.left != null)
                {
                    queue.offer(currentNode.left);
                }
                
                if (currentNode.right != null)
                {
                    queue.offer(currentNode.right);
                }
            }

            // Step 8: Add the largest value of the current level to the result
            result.add(maxVal);
        }

        // Step 9: Return the list of largest values for all levels
        return result;
    }
}