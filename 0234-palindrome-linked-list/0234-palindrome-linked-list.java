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
     public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = head;  
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
 // the second saluction is 
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
       ListNode fast = head;
       while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
       }
       ListNode j = reverseList(slow);
        ListNode i = head;
        while(j!=null){
            if(i.val!=j.val)return false;
            i= i.next;
            j = j.next;
        }
        return true;
    }
}