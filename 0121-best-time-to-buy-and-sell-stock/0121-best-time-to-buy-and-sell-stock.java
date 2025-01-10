class Solution {
    public int maxProfit(int[] prices) {

        //price[i] is price on day i
        //must buy before sell - cannot sort - and have to process in current order of the array

        //clarification questions
            // Can a stock be sold for 0?
            // Can a price be negative
            //Will there every be a carse when theire is only 1 value in the array

        //brute force:
            //nested for loop - start at index 0, looking for bigger values and return max
            //do for whole loop

            //keep a comparison for max
            int maxProfit = 0;

            //curr profit tracker
            int curr = 0;

            //to find a min 
            int min = Integer.MAX_VALUE;

        //for loop - keep track of a min price, if the new value is greater than the min price, find profit -- because we buy at min, and sell if higher
        for (int i = 0; i < prices.length; i++) {

            //if its a min, no point in calculating
            if (prices[i] < min) {
                min = prices[i];
            } else {
                //find the profit
                curr = prices[i] - min;
            }
        

            //keep track of max
            maxProfit = Math.max(curr, maxProfit);
        }

        return maxProfit;

    }
}