class Solution {
    public int maxProfit(int[] prices) {

        int currProfit = 0;

        int lowestPrice = Integer.MAX_VALUE;

        int maxProfit = 0;


        for( int price : prices) {

            //set min
            if(price < lowestPrice) {
                lowestPrice = price;
                continue;
            } else {
                currProfit = price - lowestPrice;
            }

            maxProfit = Math.max(currProfit, maxProfit);
        }

        return maxProfit;        
    }
}