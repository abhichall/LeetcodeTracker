class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1;
        int right = Integer.MIN_VALUE;
        
        // Find the maximum number of bananas in a pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        

        while (left < right) {
            int mid = (left + right) / 2;

            int hoursNeeded = 0;
            
            for (int pile : piles) {
                hoursNeeded += (pile + mid - 1 ) / mid;
            }
            
            if (hoursNeeded > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
