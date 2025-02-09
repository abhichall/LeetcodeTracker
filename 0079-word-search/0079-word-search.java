class Solution {
    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        // Step 1: Loop through the board to find the first letter match
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) { //index at the end keeps track of index of the letter in the word
                    return true; // Word found
                }
            }
        }
        return false; // Word not found
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {

        if (index == word.length()) return true; 

        // Boundary Check and Character Match Check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore all 4 possible directions
        boolean found = dfs(board, word, i + 1, j, index + 1) || // Move Down
                        dfs(board, word, i - 1, j, index + 1) || // Move Up
                        dfs(board, word, i, j + 1, index + 1) || // Move Right
                        dfs(board, word, i, j - 1, index + 1);   // Move Left

        // Backtrack: Restore the original character
        board[i][j] = temp;

        return found;
    }
}