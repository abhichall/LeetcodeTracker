class Solution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        
        int[] left = new int[n];

        int[] right = new int[n];

        int[] res = new int[n];


        left[0] = 1;
        right[n-1] = 1;

        //left
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        //right
        for (int j = n-2; j >= 0; j--) {
            right[j] = right[j+1] * nums[j+1];
        }


        //result
        for (int k = 0; k < n; k++) {
            res[k] = left[k] * right[k];
        }

return res;


    }
}