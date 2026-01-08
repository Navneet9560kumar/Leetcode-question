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
        int count = 0;
        ListNode front = null;
        ListNode end = null;
        ListNode curr = head;

        // Traverse the list to find the k-th node from the start
        while (curr != null) {
            count++;

            // Set the end pointer to the head after we reach the k-th node
            if (count == k) {
                front = curr;
                end = head;
            }

            // Move the end pointer to find the k-th node from the end
            if (count > k) {
                end = end.next;
            }

            curr = curr.next;
        }

        // Swap the values of the front and end nodes
        swapValues(front, end);

        return head;
    }

    private void swapValues(ListNode node1, ListNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}