class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int n = senate.length();

        // Populate the queues with initial indices of 'R' and 'D'
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                r.add(i);
            } else {
                d.add(i);
            }
        }

        // Process the queues
        while (!r.isEmpty() && !d.isEmpty()) {
            int rIndex = r.poll();
            int dIndex = d.poll();

            // The one with the smaller index bans the other
            if (rIndex < dIndex) {
                r.add(rIndex + n);
            } else {
                d.add(dIndex + n);
            }
        }

        // Return the winner
        return r.isEmpty() ? "Dire" : "Radiant";
    }
}