class Solution {
     public int rob( int [] nums) {


        //edge case 
        if(nums.length == 1) return nums[0]; //if theres only one house - steal that money
        if(nums.length == 2) return Math.max(nums[0], nums[1]); //if two houses, we still the max house money 


        int prevOne = 0; //represent the sums of when we are robbing house before and not current - CASE 1
        int prevTwo = 0; //represent the sume when robbing current house and curr - 2


        //iterate through each house provided in nums array 

        for(int n : nums) {
            //current max profit either robbing the current house or skipping
            int curr = Math.max(prevOne, prevTwo + n);
            prevTwo = prevOne; //move prev1 to prev2
            prevOne = curr; //uipdate prev1 with latest profit
        }
        return prevOne;
    }
}