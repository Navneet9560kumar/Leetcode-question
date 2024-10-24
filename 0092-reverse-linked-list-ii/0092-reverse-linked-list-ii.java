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
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevLeft = dummy;
        int pos = 1;

        while (pos < left) {
            prevLeft = prevLeft.next;
            pos++;
        }

        ListNode start = prevLeft.next;
        ListNode end = start;
        while (pos < right) {
            end = end.next;
            pos++;
        }

        ListNode nextRight = end.next;
        end.next = null;

        prevLeft.next = reverseList(start);
        start.next = nextRight;

        return dummy.next;
    }
}





