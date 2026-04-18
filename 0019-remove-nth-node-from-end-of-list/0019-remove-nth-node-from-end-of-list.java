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
        ListNode temp = head;
        int len  =0;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        // edge case 
        if(len==n) return head.next;
        // n from end = (len-n+1) from start
        // we need a temp  = len -n;

        temp = head;
        for(int i=1;i<=len-n-1;i++){
            temp = temp.next;

        }
        //deletion
        temp.next = temp.next.next;
        return head;
    }
}