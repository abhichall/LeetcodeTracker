class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Min-heap -- since we have list of list int[] -- we can have heap sort by first index in each list
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int currentMax = Integer.MIN_VALUE; // tracks the max for our range 
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE; // best (smallest) range found so far

        // now for the heap, add to it
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0); //gets the first index of each list
            pq.offer(new int[]{val, i, 0}); // store value, list index, element index -- this will allow us to iterate through a list and be able to call it in specific
            currentMax = Math.max(currentMax, val); // update max
        }


        // go thru rest of input
        while (pq.size() == nums.size()) { //THIS  ENSURES THERE IS A NUMBER FROM EACH LIST

            int[] curr = pq.poll(); // smallest element across current; since its arr store in arr
            int val = curr[0];
            int listI = curr[1];
            int actualI = curr[2];

            // Update best range if this one is smaller
            if (currentMax - val < rangeEnd - rangeStart) {  //constraints given in question
                rangeStart = val;
                rangeEnd = currentMax;
            }

            // move to next value of the liat 
            if (actualI + 1 < nums.get(listI).size()) {
                int nextVal = nums.get(listI).get(actualI + 1);
                pq.offer(new int[]{nextVal, listI, actualI + 1}); // push next element from same list
                currentMax = Math.max(currentMax, nextVal); // update max if needed
            }
            // If that list is exhausted → stop, because we can’t cover all lists anymore
        }

        return new int[]{rangeStart, rangeEnd};
    }
}
