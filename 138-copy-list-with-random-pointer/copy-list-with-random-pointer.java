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
    public Node copyRandomList(Node head) {

        if(head == null)
            return null;

        // Step 1: Insert copied nodes
        Node temp = head;

        while(temp != null){

            Node copy = new Node(temp.val);

            copy.next = temp.next;
            temp.next = copy;

            temp = copy.next;
        }

        // Step 2: Copy random pointers
        temp = head;

        while(temp != null){

            if(temp.random != null)
                temp.next.random = temp.random.next;

            temp = temp.next.next;
        }

        // Step 3: Separate both lists
        Node dummy = new Node(0);
        Node copy = dummy;

        temp = head;

        while(temp != null){

            copy.next = temp.next;
            copy = copy.next;

            temp.next = temp.next.next;
            temp = temp.next;

            if(copy.next != null)
                copy.next = copy.next.next;
        }

        return dummy.next;
    }
}