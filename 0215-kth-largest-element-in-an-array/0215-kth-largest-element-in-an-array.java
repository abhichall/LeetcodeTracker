class Solution {
    public int findKthLargest(int[] nums, int k) {

        //heap approach
            //priority queues - min heap - the lowest at the root 
            
            //compare it to k - if the value then q - remove the root from p
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n : nums) {
            pq.add(n);

            if (pq.size() > k) pq.poll();

        }

        return pq.poll();
    }
}