class Solution {
    public int[] runningSum(int[] nums) {

        //new int array to keep track of running
        int[] prefix = new int[nums.length];

        int temp = nums[0];
        prefix[0] = temp;


        for (int i = 1; i < nums.length; i++) {

            prefix[i] = prefix[i-1] + nums[i];
        }

        return prefix;
        
    }
}