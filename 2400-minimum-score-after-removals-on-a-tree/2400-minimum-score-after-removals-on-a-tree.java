class Solution {
    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] xor = new int[n], parent = new int[n], depth = new int[n];
        Arrays.fill(parent, -1);
        
        dfs(0, -1, adj, nums, xor, parent, depth);
        int totalXor = xor[0], minScore = Integer.MAX_VALUE;

        for (int i = 0; i < edges.length; i++) {
            for (int j = i + 1; j < edges.length; j++) {
                int[] e1 = edges[i], e2 = edges[j];
                int v1 = (depth[e1[0]] > depth[e1[1]]) ? e1[0] : e1[1];
                int v2 = (depth[e2[0]] > depth[e2[1]]) ? e2[0] : e2[1];
                
                int x1, x2, x3;
                if (isAncestor(v1, v2, parent)) {
                    x1 = xor[v2];
                    x2 = xor[v1] ^ x1;
                    x3 = totalXor ^ xor[v1];
                } else if (isAncestor(v2, v1, parent)) {
                    x1 = xor[v1];
                    x2 = xor[v2] ^ x1;
                    x3 = totalXor ^ xor[v2];
                } else {
                    x1 = xor[v1];
                    x2 = xor[v2];
                    x3 = totalXor ^ x1 ^ x2;
                }
                
                int score = Math.max(x1, Math.max(x2, x3)) - Math.min(x1, Math.min(x2, x3));
                minScore = Math.min(minScore, score);
            }
        }
        return minScore;
    }

    private void dfs(int u, int p, List<List<Integer>> adj, int[] nums, int[] xor, int[] parent, int[] depth) {
        parent[u] = p;
        xor[u] = nums[u];
        depth[u] = p == -1 ? 0 : depth[p] + 1;
        for (int v : adj.get(u)) if (v != p) {
            dfs(v, u, adj, nums, xor, parent, depth);
            xor[u] ^= xor[v];
        }
    }

    private boolean isAncestor(int a, int b, int[] parent) {
        while (b != -1 && b != a) b = parent[b];
        return b == a;
    }
}