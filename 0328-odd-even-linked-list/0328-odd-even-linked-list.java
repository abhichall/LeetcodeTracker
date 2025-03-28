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
public class Solution {
    public ListNode oddEvenList(ListNode head) {

        //check fi the lsit is empty, null, etc
        if (head == null || head.next == null) return head;

        //since we know the first node is odd
        ListNode odd = head;
        //second node is even
        ListNode even = head.next;
        
        //because we need a way to keep track of the even head, so that we can reattach the odd nodes to the even nodes
        ListNode evenHead = even;

        //traverse through
        while (even != null && even.next != null) {
            //odds connecting to odds
            odd.next = even.next;
            odd = odd.next;
            // evens connecting to evens
            even.next = odd.next;
            even = even.next;
        }

        // odd comes first so attach the chunks tog
        odd.next = evenHead;

        return head;
    }
}
