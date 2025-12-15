class Solution {
    public int maxProfit(int[] prices) {

        //edge case
        if (prices == null || prices.length < 2) return 0;

        int n = prices.length;

        //left dp array -- holds max profit with one transaction between 0 - i
        int left[] = new int[n];

        //right dp array -- holds max profit with one transaction between i-1 - n
        int right[] = new int[n];

        //build within arrays

        //tracker for min
        int minPrice = prices[0]; //its in order
        left[0] = 0; //cant have profit from same day

        for (int i = 1; i < prices.length; i++) {

            //updates min price if lower
            minPrice = Math.min(minPrice, prices[i]);

            //touch dp
            left[i] = Math.max(left[i-1], prices[i] - minPrice);
        }

        //build the right array now
        int maxPrice = prices[n-1];
        right[n-1] = 0; //no profit from last day itself
        
        for(int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, prices[i]);

            //touch dp
            right[i] = Math.max(right[i+1], maxPrice - prices[i]);
        }


        //combine the two - got till day i and after day i
        int maxProfit = 0;

        for(int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        
        return maxProfit;
    }
}

/**

given array prices - where prices[i] is given stock of ith day

given - int array
output - integer with maximum  possible 

ideas
    try all pairs -- since its 2 -- but this would be  > o n^2 

    must sell before buying again
        in roder to get most profit, have to get two most sales

    split the two transactions

        first transaction happens on day i -- find best profit before i  --t raverse left to right, track a min and dp array for best

        second transaction happens after day -- find best profit after i -- traverse right to left, track the max, and dp array for best



    split the given array, split it into two different parts
    have a left and right array -- 
        in our left array - we could hold the most profit possible from the left -- keep track of min
        in our rigth array.- we could hold the most profit possible from the right -- keep track of max


 */