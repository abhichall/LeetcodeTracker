class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right = Integer.MIN_VALUE;
        
        // Find the maximum number of bananas in a pile
        //because koko can either at 1 per hour or a WHOLE pile per hour
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        

        while (left < right) {
            int mid = (left + right) / 2; //possible speed of eating

            int hoursNeeded = 0; // 'k'
            
            for (int pile : piles) {
                hoursNeeded += (int) Math.ceil((double)pile / mid); //this will round up - ceiling functions
            }
            
            if (hoursNeeded > h) { //theres not enough time - eating too slow
                left = mid + 1; //to check fast speeds
            } else {
                right = mid; 
            }
        }
        
        return left;
    }
}
