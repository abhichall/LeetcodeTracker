class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to optimize binary search
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2; // Partition index for nums1
            int partitionY = (m + n + 1) / 2 - partitionX; // Partition index for nums2

            // Edge cases: Use MIN and MAX values when partitioning at boundaries
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            // If partitions are correct
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // If total number of elements is odd, return max of left half
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeftX, maxLeftY);
                }
                // If even, return average of max of left half and min of right half
                return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
            }
            // Adjust binary search range
            else if (maxLeftX > minRightY) {
                high = partitionX - 1; // Move left
            } else {
                low = partitionX + 1; // Move right
            }
        }

        throw new IllegalArgumentException("Arrays are not sorted properly.");
    }
}
