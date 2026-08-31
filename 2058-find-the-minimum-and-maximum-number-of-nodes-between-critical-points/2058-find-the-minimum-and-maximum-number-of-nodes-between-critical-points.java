/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * } 
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode left = head;
         ListNode mid = head.next;
          ListNode right = head.next.next;
          int first= -1,last = -1;
          int idx=1;
          int []arr = {-1,-1};
          int minDistacnce  = Integer.MAX_VALUE;
          while(right!=null){
            if(mid.val<left.val && mid.val<right.val || mid.val>left.val && mid.val>right.val){
                if(first==-1) first=idx;
                if(last!=-1){
                    int dist = idx -last;
                    minDistacnce = Math.min(minDistacnce,dist);
                }last = idx;
            

            }
            idx++;
            left = left.next;
             mid = mid.next;
              right = right.next;
          }
        if(first==last)return arr;
        int maxDistance = last - first;
        arr[0] = minDistacnce;
        arr[1]= maxDistance;
        return arr;
    }
}