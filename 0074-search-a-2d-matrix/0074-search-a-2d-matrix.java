class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix == null || matrix[0].length == 0) return false;


        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {

            int mid = (right + left) / 2;

            int val = matrix[mid / cols][mid % cols];

            if (target == val) {
                return true;
            }

            if (target > val) {
                left = mid + 1;
            } else if(target < val) {
                right = mid - 1;
            }
        }

            return false;


        
        
    }
}