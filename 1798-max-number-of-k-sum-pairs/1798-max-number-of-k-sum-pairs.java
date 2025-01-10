class Solution {
    public int maxOperations(int[] nums, int k) {

        //sort array in ascending order
        Arrays.sort(nums); 

        //pointers
        int j = 0;
        int i = nums.length - 1;

        //counter
        int counter = 0;

        while (j < i && j < nums.length && i>=0) {

            int sum = nums[j] + nums[i];

            if (sum == k) {
                counter++;
                j++;
                i--;
            }

            else if (sum < k) {
                j++;
            }

            else if (sum > k) {
                i--;
            }
        }

        return counter;
        
    }
}