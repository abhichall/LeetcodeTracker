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
    public ListNode swapPairs(ListNode head) {
        //create dummy node to point to the head of given linked list
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            //pointer to traverse 
            ListNode ptr = dummy;

            while (ptr.next != null && ptr.next.next != null) {

                //identify nodes to swap
                ListNode first = ptr.next;
                ListNode second = ptr.next.next;

                //change pointers to swap
                first.next = second.next;
                second.next = first;
                ptr.next = second;

                //account for traversal 
                ptr = first;

            }

            return dummy.next;

        }

    }