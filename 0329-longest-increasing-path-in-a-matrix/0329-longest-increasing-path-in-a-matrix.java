class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        //edge cases
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        int best = 0;

        //iterate and dfs
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                best = Math.max(best, dfs(matrix, r,c,dp));
            }
        }
        return best;
    }
    private int dfs(int[][] matrix, int r, int c, int[][] dp) {
    if (dp[r][c] != 0) return dp[r][c];

    int ctr = 1;

    int[][] dirs = { {-1,0}, {1,0}, {0,-1}, {0,1} };

    for (int[] d : dirs) {
        int nr = r + d[0];
        int nc = c + d[1];

        if (nr >= 0 && nr < matrix.length &&
            nc >= 0 && nc < matrix[0].length &&
            matrix[nr][nc] > matrix[r][c]) {

            ctr = Math.max(ctr, 1 + dfs(matrix, nr, nc, dp));
        }
    }

    dp[r][c] = ctr;
    return ctr;
}
}

/**


mxn matrix

length of longest increasing path in matrix

no wrap around
left, right, up or down


could do dfs -- checks every path
    brute force

use a memoization array
dp[i][j] -- will store the length of the longest increasing path starting at i,j
    dfs call for each 4 neighbors -- only compute once, and can use past stored to build off
    each dfs call -- return 1 + max of valeus stored within dp array

 */