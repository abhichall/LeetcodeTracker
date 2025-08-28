class Solution {
    public int rob(int[] nums) {

        //edge cases
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        //store the max amount of money robbed till the house i - 1 -- it woudl be either the first value or second depending on max - both work
        int oneBefore = Math.max(nums[0], nums[1]);
        //store the max amount of money robbed till the house i - 2
        int twoBefore = nums[0];

        //iterate through the nums array
        for (int i = 2; i < nums.length; i++) {
            
            // current max amount at house I
            int curr = Math.max(oneBefore, (twoBefore + nums[i]));
            
            //update the values to keep moving through
            twoBefore = oneBefore;
            oneBefore = curr;

        }
        
        //since this is always moved to hold current value
        return oneBefore;


    }
}
        
     
        //could iterate through nums with a fixed pointer, to cover all possible possibiiits of robbing -- have a max comparision to keep track of max amount -- o n exponential

        // test case

            // if odd number of houses - most number of houses is starting at first - but the other values could be higher so that wont work

            // we are at house i

            // we had array final, stored the total up to each i'th house

                // ROB house i -- this would mean that ur current total is equal to house i + final[i - 2]
                // skip this house -- total at this current house is just final[i-1]

            // iterate through the array and then if the case 1 is greater than case 2, could have max operator to compare
            //at the end, the alst value in the final array would hold the maximum amount of money possible to steal

            // time complexity - o(n) space complexity - o(n)

            //we only need i -1 and i -2 to calculate the max up to a current house. the entire array of ith house maxes is extra space
            // two variabels, one for prev1 house and then prev2 house
                // while iterating through the for loop, since prev1 would get max of house prior and prev 2 + curr would get house of current we compare

                // update prev 2 to prev 1
                // prev 1 to current 
                // by the end of iteration, prev1 should be max amount of money to rob
        // 