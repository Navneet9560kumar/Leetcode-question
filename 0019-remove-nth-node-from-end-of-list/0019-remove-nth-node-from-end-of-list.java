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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode slow =head;
       ListNode fast = head;
        // move fast n step shead
        for(int i=1;i<=n;i++){
            fast=fast.next;
          
        }
        if(fast==null){
            // i have  to delete the head
            return head.next;
        }
        //move slow and fast together 
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}