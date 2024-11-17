class Solution {
 public int shortestSubarray(int[] nums, int k) {
        long sum = 0;
        int n = nums.length;
        long ans = Long.MAX_VALUE;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum >= k) {
                ans = Math.min(ans, i + 1);
            }

            while (!pq.isEmpty() && (sum - pq.peek()[0]) >= k) {
                ans = Math.min(ans, i - pq.peek()[1]);
                pq.poll();
            }

            pq.offer(new long[]{sum, i});
        }

        return ans == Long.MAX_VALUE ? -1 : (int) ans;
    }
}