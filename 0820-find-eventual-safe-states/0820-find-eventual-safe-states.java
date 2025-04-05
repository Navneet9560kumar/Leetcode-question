import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        
        // Step 1: Create reverse graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int ele : graph[i]) {
                adj.get(ele).add(i); // Reverse the edge
                indegree[i]++;
            }
        }

        // Step 2: Apply Kahn's Algorithm (Topological Sort)
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int front = q.poll();
            ans.add(front);

            for (int neighbor : adj.get(front)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Step 3: Sort the result before returning (as per LeetCode format)
        Collections.sort(ans);
        return ans;
    }
}
