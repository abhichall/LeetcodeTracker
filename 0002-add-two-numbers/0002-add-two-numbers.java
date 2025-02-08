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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;

        //keep track of carry amt
        int carry = 0;

        while(l1 != null || l2 != null) {
            
        
            int l1Val = (l1 != null) ? l1.val : 0;
            int l2Val = (l2 != null) ? l2.val : 0;
            
            //add digits
            int currSum = l1Val + l2Val + carry;
            carry = currSum / 10;
            int lastDigit = currSum % 10;

            ListNode nodeVal = new ListNode(lastDigit); // Create new node
            ptr.next = nodeVal; // Link the new node
            ptr = ptr.next; // Move pointer to new node

            // Move to the next nodes in both lists if available
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

            if (carry > 0) {
                ListNode lastAmt = new ListNode(carry);
                ptr.next = lastAmt;
                ptr = ptr.next;
            }

            return dummy.next;

    }

}


