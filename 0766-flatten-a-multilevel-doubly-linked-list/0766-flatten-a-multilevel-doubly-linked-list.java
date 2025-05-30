/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

// class for node
    //int
    //prev
    //next 
    //child

// not every child pointer will have smt

//edge case - if input is null -- return head

public class Solution {
    public Node flatten(Node head) {
        flattenDFS(head);
        return head;
    }

    private Node flattenDFS(Node node) {
        Node curr = node;
        Node last = null;

        while (curr != null) {
            Node next = curr.next;

            // If no child, move on
            if (curr.child == null) {
                last = curr;
                curr = next;
            } else {
                // Flatten the child list
                Node childHead = curr.child;
                Node childTail = flattenDFS(childHead);

                // Connect curr with child head
                curr.next = childHead;
                childHead.prev = curr;

                // If next existed, connect tail to next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                // Child is now merged, so set to null
                curr.child = null;

                // Move to the end of the flattened child list
                last = childTail;
                curr = next;
            }
        }
        return last;
    }
}
