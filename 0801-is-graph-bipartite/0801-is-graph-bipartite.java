class Solution {
    static boolean ans;

    public void bfs(int i, int[][] adj, int[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = 0; // Assign initial color
        
        while (!q.isEmpty()) {
            int front = q.remove();
            int colour = vis[front];
            
            for (int ele : adj[front]) {
                if (vis[ele] == colour) { // Conflict found
                    ans = false;
                    return;
                }
                if (vis[ele] == -1) { // Not visited
                    vis[ele] = 1 - colour; // Assign opposite color
                    q.add(ele);
                }
            }
        }
    }

    public boolean isBipartite(int[][] graph) {
        ans = true;
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1); // Initialize as unvisited

        for (int i = 0; i < n; i++) {
            if (vis[i] == -1) { // Only process unvisited nodes
                bfs(i, graph, vis);
            }
        }
        return ans;
    }
}