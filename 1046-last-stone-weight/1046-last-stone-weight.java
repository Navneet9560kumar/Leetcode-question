class Solution {
    public int lastStoneWeight(int[] arr) {
          int n=  arr.length;
            ArrayList<Integer>st = new ArrayList<>();
            PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());
            for(int ele: arr){
                pq.add(ele);
            }
            while(pq.size()>1){
              int y = pq.poll();
              int x = pq.poll();
                    if (y != x) {
                pq.add(y - x);
            }
            }
          return pq.isEmpty() ? 0 : pq.poll();

    }
}