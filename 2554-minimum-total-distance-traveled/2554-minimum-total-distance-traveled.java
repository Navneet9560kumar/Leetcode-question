class Solution {
   public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
    // Robots aur factories ko position ke hisaab se sort karte hain taaki optimal assignment ho sake
    Collections.sort(robot);
    Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
    
    int m = robot.size();
    int n = factory.length; 
    
    // dp[i][j] min total distance ko represent karta hai robots[i:] ke liye factories[j:] ka use karke
    long[][] dp = new long[m + 1][n + 1];
    
    // Boundary condition ke liye last column ko MAX_VALUE set karte hain
    for (int i = 0; i < m; i++) {
        dp[i][n] = Long.MAX_VALUE;
    }
    
    // Har factory ko right se left mein process karte hain
    for (int j = n - 1; j >= 0; j--) {
        // Current factory se robots tak cumulative distance track karte hain
        long prefix = 0;
        // Deque use karte hain taaki potential optimal assignments maintain kar sake
        Deque<Pair<Integer, Long>> qq = new ArrayDeque<>();
        // Boundary condition ke saath initialize karte hain
        qq.offer(new Pair<>(m, 0L));
        
        // Har robot ko right se left mein process karte hain
        for (int i = m - 1; i >= 0; i--) {
            // Current robot se current factory tak distance add karte hain
            prefix += Math.abs(robot.get(i) - factory[j][0]);
            
            // Assignments ko remove karte hain jo factory capacity se zyada hain
            while (!qq.isEmpty() && qq.peekFirst().getKey() > i + factory[j][1]) {
                qq.pollFirst();
            }
            
            // Suboptimal assignments ko remove karte hain
            while (!qq.isEmpty() && qq.peekLast().getValue() >= dp[i][j + 1] - prefix) {
                qq.pollLast();
            }
            
            // Current state ko deque mein add karte hain
            qq.offerLast(new Pair<>(i, dp[i][j + 1] - prefix));
            // dp ko optimal assignment ke saath update karte hain
            dp[i][j] = qq.peekFirst().getValue() + prefix;
        }
    }
    
    // Sabhi robots ke liye minimum total distance ko return karte hain
    return dp[0][0];
}

// Helper class key-value pairs ko store karne ke liye
private static class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() {
        return key;
    }
    
    public V getValue() {
        return value;
    }
}
}
