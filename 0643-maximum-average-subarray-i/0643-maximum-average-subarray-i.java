class Solution {
    public double findMaxAverage(int[] nums, int k) {

        //find  intial sum of k
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];

        }

        //j assumes max sum. is sum
        int maxSum = sum;


    
    //sliding window alg

        //pointers
        int left = 0;
        int right = k;
    

        while (right < nums.length) {

            //remove the previous element in window
            sum = sum - nums[left];
            left++;

            //adds next value in window
            sum = sum + nums[right];
            right++;


            //sets maxSum to the larger value
            maxSum = Math.max(sum, maxSum);

        }

        return (double) maxSum/k;


    }
}