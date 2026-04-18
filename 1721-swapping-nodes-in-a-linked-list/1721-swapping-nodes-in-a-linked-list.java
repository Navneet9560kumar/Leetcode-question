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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        // Step 1: move fast to k-th node
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }

        ListNode first = fast;// k-th from start

        // Step 2: move both until fast reaches end

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode second = slow; // k-th from end

      

       // Step 3: swap values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;

    }
}