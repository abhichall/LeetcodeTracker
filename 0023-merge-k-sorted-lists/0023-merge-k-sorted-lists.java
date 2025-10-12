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
        if (lists == null || lists.length == 0) return null;

        //min heap order by node val
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        for (ListNode node : lists) {
            if (node != null) minHeap.offer(node);
        }

        //dummy pointers
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        //while present in heap, popo and append
        while(!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll(); //will hold the smallest
            tail.next = smallest; //append to the merged list
            tail = tail.next;   //move the tail

            //if this head has a next value then we push that to heap
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }

            
        }
        return dummy.next;
    
}
}
/*
IDEAS
    get all the avlues of the nodes into an array
    sort
    write this into a linked list 
    Onlogn -- bad efficiency

    needs to be ascending 
    pushed into a min heap -- o logn

    have heap initialized with the head of each list
    then go into that list when we do access it

*/