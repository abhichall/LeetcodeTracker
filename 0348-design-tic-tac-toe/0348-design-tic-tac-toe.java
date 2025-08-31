class TicTacToe {

    int[] rows;
    int[] cols;
    int diag;
    int oppDiag;
    int n;

    public TicTacToe(int n) {
        this.n = n;
        this.rows = new int[n];
        this.cols = new int[n];
        this.diag = 0;
        this.oppDiag = 0;
    }
    
    public int move(int row, int col, int player) {
        // Player 1 -> +1   Player 2 -> -1
        int currPlayer = (player == 1) ? 1 : -1;

        // update row and column counts
        rows[row] += currPlayer;
        cols[col] += currPlayer;

        // update diagonals
        if (row == col) {
            diag += currPlayer;
        }
        if (row + col == n - 1) {
            oppDiag += currPlayer;
        }

        // check if any line reaches n
        if (Math.abs(rows[row]) == n || 
            Math.abs(cols[col]) == n || 
            Math.abs(diag) == n || 
            Math.abs(oppDiag) == n) {
            return player;  // return 1 or 2
        }

        return 0; // no winner yet
    }
}