class Solution {
    public int[] deckRevealedIncreasing(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[q.poll()] = arr[i];
            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }
        return res;
        
    }
}