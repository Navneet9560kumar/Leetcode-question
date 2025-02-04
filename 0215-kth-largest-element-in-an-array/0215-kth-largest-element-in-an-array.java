class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>q=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            q.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            q.add(nums[i]);
            while(q.size()>k){
                q.poll();
            }
        }
        return q.poll();
    }
}