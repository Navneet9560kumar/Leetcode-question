
class Solution {
    public int pairSum(ListNode head) {
        // find middle
        ListNode slow = head, fast = head;
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse second half
        ListNode prev = null, curr = slow, nextNode =null;
        while(curr!=null){
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
         // Calculate twin sum
        int result = 0;
        ListNode first = head, second = prev;
        while (second != null) {
            result = Math.max(result, first.val + second.val);
            first = first.next;
            second = second.next;
        }
        
        return result;
    }
}