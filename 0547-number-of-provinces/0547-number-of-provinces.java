class Solution {
      public static int findCircleNum(int[][] adj) {
            int n = adj.length;
            int count = 0;
            boolean[] vis = new boolean[n]; // har node ke leye vissbile hai ke nahi hai vo is leye ban rahe hai ham
            for (int i = 0; i < adj.length; i++) {
                  if (!vis[i]) {
                        dfs(adj, vis, i);
                        count++;
                  }
            }
            return count;
      }

      private static void dfs(int[][] adj, boolean[] vis, int i) {
            vis[i] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                  int front = q.remove();
                  for (int j = 0; j < adj.length; j++) {
                        if (adj[front][j] == 1 && !vis[j]) {
                              q.add(j);
                              vis[j] = true;
                        }
                  }
            }
      }

}