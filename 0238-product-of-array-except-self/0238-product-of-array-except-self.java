class Solution {
    public int[] productExceptSelf(int[] nums) {

        //create an int array for answer
        int[] answer = new int[nums.length];

        //for loops to iterate through the array
        
            //for left multiples, start with left = 1 because the left of the left most should be 1
            for(int i = 0, left = 1; i < nums.length; i++) {
                answer[i] = left;
                left = left * nums[i];
            }
            //after this loop above, all the values in the answer array are now the product of all the left values of each index

            //now same thing for the right
            for(int i = nums.length - 1, right = 1; i >= 0; i--) {
                
                answer[i] = right * answer[i];
                right = right * nums[i];
            }
        return answer;
    }
}