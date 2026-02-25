class Solution {
    public long pickGifts(int[] arr, int k) {
         int n= arr.length;
        
    ArrayList<Integer>st = new ArrayList<>();
  PriorityQueue<Integer> pq =new PriorityQueue<>(Collections.reverseOrder());
  for(int ele: arr){
    pq.add(ele);
  }

  while(k>0){
int max = pq.poll();
int root = (int )Math.sqrt(max);
pq.add(root);
k--;
}
   long sum = 0;
 while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;





  
         
    }
}