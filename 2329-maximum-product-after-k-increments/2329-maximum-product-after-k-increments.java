class Solution {
    public int maximumProduct(int[] nums, int k) {
          
        final int MOD = 1_000_000_007;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }

        while (k > 0) {
            int minElement = pq.poll();
            minElement++;
            pq.offer(minElement);
            k--;
        }

        long product = 1;
        while (!pq.isEmpty()) {
            product = (product * pq.poll()) % MOD;
        }

        return (int) product;
    }
}