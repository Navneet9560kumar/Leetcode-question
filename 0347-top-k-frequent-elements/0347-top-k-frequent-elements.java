class Solution {
   public class Pair implements Comparable<Pair> {
        int val;
        int freq;

        Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }

        // compare based on frequency
        public int compareTo(Pair p) {
            return this.freq - p.freq; // min-heap based on frequency
        }
    }

    public int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // count frequencies
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        // create a min-heap (smallest frequency at top)
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // add elements to heap
        for (int ele : map.keySet()) {
            pq.add(new Pair(ele, map.get(ele)));
            if (pq.size() > k) {
                pq.remove(); // remove smallest frequency
            }
        }

        // extract top k frequent elements
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) { // reverse order for correct ranking
            ans[i] = pq.remove().val;
        }

        return ans;
    }
}