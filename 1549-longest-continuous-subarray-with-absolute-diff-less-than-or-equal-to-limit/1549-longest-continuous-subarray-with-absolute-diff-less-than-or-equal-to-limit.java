class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        //sliding window to iterature thru nums[] - this will allow for us maintain the max and minumum in current window

    //deques to track min and max values in curr window
    Deque<Integer> maxD = new ArrayDeque<>();
    Deque<Integer> minD = new ArrayDeque<>();


    int l = 0;
    int maxLength = 0;

    for (int r = 0; r < nums.length; r++) {
        
        //maintain the max deque
        while(!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[r]) {
            maxD.pollLast();
        }
            maxD.addLast(r); //is the current max for the given window
        
        //maintain the min deque
        while(!minD.isEmpty() && nums[minD.peekLast()] >= nums[r]) {
            minD.pollLast();
        }
            minD.addLast(r); // current min for given window
        
        //change the window if limit exceeds
        while(nums[maxD.peekFirst()] - nums[minD.peekFirst()] > limit) {
            l++; //since limit exceeded, we need to change the window
            
            //once we move the l pointer, we want to get rid of that in our deques
            if(maxD.peekFirst() < l) {
                maxD.pollFirst();
            }
            if(minD.peekFirst() < l) {
                minD.pollFirst();
            }
        }
        
        maxLength = Math.max(maxLength, (r - l) + 1);
    }
    return maxLength;
}
}
