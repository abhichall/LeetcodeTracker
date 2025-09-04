class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < nums[mid + 1]) {
                // Peak must be on the right
                left = mid + 1;
            } else {
                // Peak is on the left side or at mid
                right = mid;
            }
        }
        
        return left; // or right, they meet at the peak
    }
}

/**

nums = [1 2 3 1]
output = 2
3 is peak elemnent -- index is 2


binary search 

    the peak cant be the first value or last value
    must be between
    if we find where nums[i] < nums[i + 1] we know that some sort fo peak exists on the right side (since peak must be the greatest when compared to surroundings)
    and vice versa

    [1 2 3 1]


 */