/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
 private Node deepcopy(Node head) {
        Node head2 = new Node(head.val);
        Node t1 = head.next;
        Node t2 = head2;
        while (t1 != null) {
            Node temp = new Node(t1.val);
            t2.next = temp;
            t2 = t2.next;
            t1 = t1.next;
        }
        return head2;
    }

    private void connectAlternatively(Node head, Node head2) {
        Node t1 = head;
        Node t2 = head2;
        
        while (t1 != null && t2 != null) {
            Node t1Next = t1.next;
            Node t2Next = t2.next;
            
            t1.next = t2;
            if (t1Next != null) t2.next = t1Next;

            t1 = t1Next;
            t2 = t2Next;
        }
    }

    private void split(Node head, Node head2) {
        Node t1 = head;
        Node t2 = head2;

        while (t1 != null && t2 != null) {
            Node t1Next = t2.next;
            t1.next = t1Next;
            t1 = t1Next;

            if (t1 != null) {
                t2.next = t1.next;
                t2 = t2.next;
            }
        }
    }

    private void assignRandom(Node head) {
        Node t1 = head;
        
        while (t1 != null) {
            if (t1.random != null) {
                t1.next.random = t1.random.next;
            }
            t1 = t1.next.next;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Create a deep copy of the list without random pointers.
        Node head2 = deepcopy(head);

        // Step 2: Connect nodes alternatively to link original and copied nodes.
        connectAlternatively(head, head2);

        // Step 3: Assign random pointers.
        assignRandom(head);

        // Step 4: Split the lists to separate the copied list from the original.
        split(head, head2);

        return head2;
    }
}