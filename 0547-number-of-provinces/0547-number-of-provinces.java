class Solution {
    static int[] parent;

    public static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]); // Path compression
    }

    public static void union(int a, int b) {
        int leaderA = find(a);
        int leaderB = find(b);
        if (leaderA != leaderB) {
            parent[leaderB] = leaderA; // Merge the sets
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];

        // Initially each node is its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Connect the cities
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // Avoid duplicate checks (i,j) == (j,i)
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        // Count unique parents (number of provinces)
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) count++;
        }

        return count;
    }
}
