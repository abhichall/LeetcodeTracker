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

        if (head == null) return null;

        
        //store orig node 
        Map<Node, Node> hmap = new HashMap<>();

        Node curr = head;

        while(curr != null ) {
            hmap.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        //assigned the next and random pointers
         curr = head; //reassign
        while(curr != null) {
            hmap.get(curr).next = hmap.get(curr.next);
            hmap.get(curr).random = hmap.get(curr.random);
            curr = curr.next;
        }


    return hmap.get(head);

        
        
    }
}