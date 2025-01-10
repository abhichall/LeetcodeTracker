class Solution {
    public int removeElement(int[] nums, int val) {

        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            
            //refers to every valid value
            if ( nums[i] != val) {
                nums[counter] = nums[i];
                counter++;
            }

        }

        return counter;
        
    }
}