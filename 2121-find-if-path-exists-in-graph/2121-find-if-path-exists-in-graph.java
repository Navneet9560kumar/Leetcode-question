class Solution {
  public boolean validPath(int n, int[][] edges, int start, int end) {
        if (start == end) return true; 
        
        List<List<Integer>> abj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            abj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (a < n && b < n) { 
                abj.get(a).add(b);
                abj.get(b).add(a);
            }
        }

        boolean[] vis = new boolean[n];
        vis[start] = true;
        bfs(start, abj, vis);
        return vis[end];
    }

    private void bfs(int start, List<List<Integer>> abj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int front = q.poll();
            for (int ele : abj.get(front)) {
                if (!vis[ele]) {
                    q.add(ele);
                    vis[ele] = true;
                }
            }
        }
    }
}