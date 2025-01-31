class Solution {
    public int[] productExceptSelf(int[] nums) {

        int size = nums.length;
        int[] ans = new int[size];


        //prefix
        int[] left = new int[size];

        //postfix
        int[] right = new int[size];

        //left most and right most will b 1 since there is no val outside
        left[0] = 1;
        right[size - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        for (int i = size - 2; i >= 0; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }
return ans;
    }
}