class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        //edge case
        if ( nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        int n = nums.length;

        int numWindows = n - k + 1;
        int[] result = new int[numWindows];

        //deque to store
        Deque<Integer> d = new ArrayDeque<>();

        int currIndex = 0;

        for (int i = 0; i < n; i++) {

            //remove values less than the curren element (since they can never be max in window)
            while(!d.isEmpty() && nums[d.peekLast()] < nums[i]) {
                d.removeLast();
            }

            //add current
            d.addLast(i); //will be the lowest

            //iff length exceeds window, out
            if(!d.isEmpty() && d.peekFirst() <= i - k) {
                d.removeFirst();
            }

            //been thru window size
            if (i >= k - 1) {
                result[currIndex++] = nums[d.peekFirst()]; 
            }
        }
        return result;
    }
}



/* 

given array of nums
some window size k
starts at very left 
    move by one to the right

return the max sliding window (what this means)
    what is max sliding window? just an array with a max from each window

iterate through each wihtin the window -- too much time

use with o1 add time - deque (store the index of elements)
    front of deque holds index of current window max

iterate through the array only once
    every new element, we can pop the smaller elemnts from the tail of the deque, push the current index, and pop the head


*/