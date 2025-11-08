class Solution {
     public int findKthLargest(int[] nums, int k){
 PriorityQueue<Integer>q=new PriorityQueue<>();
 for(int ele:nums){
      q.add(ele);
      if(q.size()>k){
           q.remove();
 }
 
}
 return q.peek();
        }
}