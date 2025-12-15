class Solution {
    public int maximalSquare(char[][] matrix) {
        
        //edge cases
        if (matrix == null || matrix.length == 0 ) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        //dp where dp[i][j] == largest square with the bottom right being i,j
        int[][] dp = new int[rows][cols];
        int max = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (matrix[i][j] == '1') {
                    //check if this is first row or col
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                    }

                    // update max side length 
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max*max;
    }
}

/**

binary matrix. - 0 or 1 entry

find the larhgest square

    what is defined as a square
        equal length and with units - need to know if any of those equal units have 1's inside

        doing every single type of combination bad for time 

        build our way up
        dp apprach
        dp[i][j] --> the i,j represents the bottom right corner
            matrix[i,j] == 1 , cn increase values based on the previous neighbors




 */