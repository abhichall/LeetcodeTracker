class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        

        while (left <= right) {
            int mid = (right + left) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            if(target < nums[mid]) {
                right = mid - 1;
                continue;
            } else if(target > nums[mid]) {
                left = mid + 1;
                continue;
            }
        }

        return -1;
        
    }
}