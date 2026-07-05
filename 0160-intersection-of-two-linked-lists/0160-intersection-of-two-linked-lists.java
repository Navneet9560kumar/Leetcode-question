
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        // while(tempA == tempB){
        //     tempA = tempA.next;
        //     tempB = tempB.next;
        //     if(tempA==tempB) retrun tempB;
        // } 
        // return -1;
        int lenA = 0;

        while (tempA != null) {
            tempA = tempA.next;
            lenA++;
        }
        int lenB = 0;
        while (tempB != null) {
            tempB = tempB.next;
            lenB++;
        }
        tempA = headA;
        tempB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                tempA = tempA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                tempB = tempB.next;
            }
        }
        
        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}