class Solution {
    public int[] getConcatenation(int[] nums) {
        
        int[] array2 = new int[2*nums.length];

        for (int i = 0; i < array2.length; i++ ) {
            array2[i] = nums[i%nums.length];
            }
     return array2;
    
    }

   
}