class Solution {
 

     public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);

        for (int i = 0; i < n; i++) {
            if (vis[i] == -1) {
                if (!bfs(i, graph, vis)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int start, int[][] graph, int[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : graph[node]) {
                if (vis[neighbor] == -1) {
                    vis[neighbor] = 1 - vis[node];
                    q.add(neighbor);
                } else if (vis[neighbor] == vis[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}