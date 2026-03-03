class Solution {

    void buildGraph(TreeNode root, TreeNode parent, ArrayList<ArrayList<Integer>> adj) {
        if (root == null) return;

        int u = root.val;

        if (parent != null) {
            int v = parent.val;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        buildGraph(root.left, root, adj);
        buildGraph(root.right, root, adj);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> ans = new ArrayList<>();

        // Step 1: Create adjacency list of size 501
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= 500; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Build graph
        buildGraph(root, null, adj);

        // Step 3: Normal BFS from target
        boolean[] visited = new boolean[501];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(target.val);
        visited[target.val] = true;

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            if (distance == k) {
                for (int node : queue) {
                    ans.add(node);
                }
                return ans;
            } 


            
 
            for (int i = 0; i <  size; i++) {
                int node = queue.poll();

                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }

            distance++;
        }

        return ans;
    }
}