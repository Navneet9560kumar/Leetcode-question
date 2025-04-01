class Solution {
    public static boolean canVisitAllRooms(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n]; // har node ke leye vissbile hai ke nahi hai vo is leye ban rahe hai ham jaha har ghar false hai
        visited[0] = true;
        bfs(0, adj, visited); // 0 se start kar rahe hai kyuki 0 se hi sab kuch shuru hota hai

        for (boolean ele : visited) {
            if (!ele) return false; // agar koi bhi node false hai to return false kar do kyuki sabhi ghar nahi ghoome hai
        }
        return true; // agar sabhi ghoom chuke hai to return true
    }

    private static void bfs(int start, List<List<Integer>> adj, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int front = q.remove(); // queue se front nikaal rahe hai
            for (int ele : adj.get(front)) { // front se jo bhi ghar hai unhe check kar rahe hai
                if (!visited[ele]) { // agar ghar nahi ghoome hai to unhe ghoomne do
                    visited[ele] = true; // ghar ko ghoomne ke liye true kar do
                    q.add(ele); // ghar ko queue me daal do taaki unhe bhi ghoom sake
                }
            }
        }
    }
}