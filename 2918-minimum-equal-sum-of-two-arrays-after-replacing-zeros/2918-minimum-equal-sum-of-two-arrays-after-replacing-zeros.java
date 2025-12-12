class Solution {
    public long minSum(int[] nums1, int[] nums2) {

        //variables to hold
        long base1 = 0;
        long base2 = 0;

        int zero1 = 0; 
        int zero2 = 0;

        //compute the # of zeros and the min sum for each
        for (int n : nums1) {
            if (n==0) {
                zero1++;
            } else base1 += n;
        }

        for (int n: nums2) {
            if (n==0) {
                zero2++;
            } else base2 += n;
        }

        //find the minimum achievable sum
        long min1 = base1 + (long)zero1; //zeroes show any pos value, so anythin that is base + x is possible
        long min2 = base2 + (long)zero2;


        //Cases

            //Case 1: both arrays have NO ZEROES -- this means that the sum has it as best possible value
            if (zero1 == 0 && zero2 == 0) {
                return base1 == base2 ? base1 : -1;
            }

            //Case 2: array1 has not fixed zeroes, array2 can
            if (zero1 == 0) { //min rn is going to be the one withouth the 0's
                return base1 >= min2 ? base1 : -1;
            }

            //Case 3: same, but for arrray 2
            if(zero2 == 0) {
                return base2 >= min1 ? base2 : -1;
            }

            //Case 4: both arrays have at least one zero (only other option)
                //would just be the only max
            return Math.max(min1, min2);

        
    }
}

/**

input -- two nums array - positive integers
output -- minimum equal sum (integer form)


must replace all the 0's with non negative numbers 

ideas
    find the sume of the non zero nubers, and also keep track of the count of 0s - know what min sum is num + z

    if both arrays have NO ZEROS
        sums must already bye equal as per the question
    if one array has zeroes and the other is fixed (no zeros)
        sum must be >= minim sum with zeores
    if both arrays have 0's
        both can reach some integer >= minimaml -- minSum = max(arr1, arr2)

    look at the min sum, and return that based on the constrains, 

 */