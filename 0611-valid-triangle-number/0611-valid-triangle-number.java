class Solution {
    public int triangleNumber(int[] nums) {
        // Sort the array first
        Arrays.sort(nums);
        
        int count = 0;
        int n = nums.length;

        // Traverse the array backwards, treating nums[i] as the largest side (c)
        for (int i = n - 1; i >= 2; i--) {
            int left = 0; // Start pointer
            int right = i - 1; // End pointer

            // Find all pairs (left, right) such that nums[left] + nums[right] > nums[i]
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    // If nums[left] + nums[right] > nums[i], then all pairs between left and right are valid
                    count = count + (right - left);
                    right--; // Move the right pointer left to explore other possible pairs
                } else {
                    left++; // Move the left pointer right to find a larger sum
                }
            }
        }
        
        return count;
    }
        
    }
