class Solution {
    public void moveZeroes(int[] nums) {
        int counter = 0;
        int j = 0;

        for (int num: nums) {

            if (num == 0) {
                counter++;
            }

            if(num != 0) {
                nums[j] = num;
                j++;
            }

        }

        for(int k = 0; k < counter; k++) {
            nums[j] = 0;
            j++;
        }
    }
}