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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode temp = head;
        int n=0;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        k%=n;
        if(head==null|| head.next==null|| k==0) return head;
            ListNode slow=head;
            ListNode fast = head;

            for(int i =1;i<=k;i++){
                fast = fast.next;
            }while(fast.next!=null){
                slow = slow.next;
                   fast = fast.next;
            }
            ListNode newHead = slow.next;
            slow.next=null; // slow ab nayi tail per hai
            fast.next= head;
            return newHead;

    }
}