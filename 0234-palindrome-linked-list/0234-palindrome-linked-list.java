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
        ListNode next = head;  // Fixed variable name to 'next' (lowercase)
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        // Creating a new copy of the original list
        ListNode newHead = new ListNode(head.val);
        ListNode t1 = head.next;
        ListNode t2 = newHead;
        
        while (t1 != null) {
            ListNode temp = new ListNode(t1.val);
            t2.next = temp;
            t2 = t2.next;
            t1 = t1.next;
        }

        // Reverse the copied list
        newHead = reverseList(newHead);

        // Compare the original list and the reversed copy
        t1 = head;
        t2 = newHead;
        while (t1 != null) {
            if (t1.val != t2.val) return false;
            t2 = t2.next;
            t1 = t1.next;
        }
        
        return true;
    }
}