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
    public ListNode mergeKLists(ListNode[] lists) {
        
        //check if null or not anything
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

        //linkedlist- only stores head so each node is first
        for(ListNode node : lists) {
            if (node != null) minHeap.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;

        while(!minHeap.isEmpty()) {
            ListNode small = minHeap.poll();
            ptr.next = small;
            ptr = ptr.next;
        
            if (small.next != null) {
                minHeap.add(small.next);
            }
        
        }

        return dummy.next;
    }

}