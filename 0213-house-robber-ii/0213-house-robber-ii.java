class Solution {
    public int rob(int[] nums) {

        //edge cases

        if(nums.length == 1) return nums[0]; //if only one house

        //private function to calculate 2 different scenarios
        int robFirst = planRob(nums, 0, nums.length - 2);
        int robSecond = planRob(nums, 1, nums.length - 1);

        return Math.max(robFirst, robSecond);

       
        
    }

    private int planRob(int[] nums, int start, int end) {

        //pointers to hold 
        int lastTwo = 0;
        int lastOne = 0;

        //hold the max for current day
        int curr = 0;

        for (int i = start; i <= end; i++) {
            
            //math
            curr = Math.max(lastOne, lastTwo + nums[i]);

            lastTwo = lastOne;
            lastOne = curr;
        }

    return curr; //will output the max amount of money from a given start and end point

    }
}


// Similar logic to house robber 1

// in circle, two cases -- rob first house, not last || rob last house, not first


// if we rob the first house, the last house we rob has to be n - 2
// if we skip the first house, the last house we rob has to be n - 1

// two var - keep track of house two before and one before
// current track max until ith house

// if rob ith house, then total is ith + n - 2
// if skip ith house, total is n - 1


