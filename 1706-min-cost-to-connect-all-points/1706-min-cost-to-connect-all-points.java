class Triplet implements Comparable<Triplet> {
    int node;
    int parent; // optional, but keeping because you added it
    int dist;

    Triplet(int node, int parent, int dist) {
        this.node = node;
        this.parent = parent;
        this.dist = dist;
    }

    @Override
    public int compareTo(Triplet t) {
        if (this.dist == t.dist) return Integer.compare(this.node, t.node);
        return Integer.compare(this.dist, t.dist);
    }
}



class Solution {
        public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(0, -1, 0));

        boolean[] visited = new boolean[n];
        int sum = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {
            Triplet top = pq.poll();
            int node = top.node;
            int dist = top.dist;

            if (visited[node]) continue;

            visited[node] = true;
            sum += dist;
            count++;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int x1 = points[node][0], y1 = points[node][1];
                    int x2 = points[i][0], y2 = points[i][1];
                    int mDis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                    pq.add(new Triplet(i, node, mDis));
                }
            }
        }

        return sum;
    }
}