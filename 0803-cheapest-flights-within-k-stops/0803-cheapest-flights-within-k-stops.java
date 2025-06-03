import java.util.*;

class Solution {

    static class Pair {
        int node, cost;
        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static class Triplet {
        int node, cost, stops;
        Triplet(int node, int cost, int stops) {
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        // [node][stops] = min cost to reach node with stops
        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;

        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(src, 0, 0));

        while (!q.isEmpty()) {
            Triplet cur = q.poll();
            int node = cur.node, cost = cur.cost, stops = cur.stops;

            if (stops > k) continue;

            for (Pair nei : adj.get(node)) {
                int newCost = cost + nei.cost;
                if (newCost < dist[nei.node][stops + 1]) {
                    dist[nei.node][stops + 1] = newCost;
                    q.add(new Triplet(nei.node, newCost, stops + 1));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            min = Math.min(min, dist[dst][i]);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
