class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->a[0]!=b[0]?a[0] - b[0]:a[1]-b[1]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }

        long sum = 0;
        boolean[] vis = new boolean[n];
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int val = top[0], ind = top[1];
            if (vis[ind]) continue;
            sum += val;
            vis[ind] = true;
            if (ind - 1 >= 0) vis[ind - 1] = true;
            if (ind + 1 < n) vis[ind + 1] = true;
        }
        return sum;
    }
}