class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak element
            if ((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])) {
                return mid;
            }
            // If the left neighbor is greater, search in the left half
            else if (mid > 0 && nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            }
            // If the right neighbor is greater, search in the right half
            else {
                left = mid + 1;
            }
        }

        // In case of no peaks (not possible for this problem with the given constraints)
        return -1;
    }
}
