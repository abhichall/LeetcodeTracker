class Solution {



    // FULL_MASK: bits 0..8 set → 0b111111111 = 0x1FF
    static final int FULL_MASK = (1 << 9) - 1;

    



    public void solveSudoku(char[][] board) {

        int[] rows = new int[9];   // bitmask for each row
        int[] cols = new int[9];   // bitmask for each column
        int[] boxes = new int[9];  // bitmask for each 3x3 box

        List<int[]> empties = new ArrayList<>();

        // Scan board and initialize masks
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                char ch = board[r][c];
                int boxIndex = (r / 3) * 3 + (c / 3);

                if (ch == '.') {
                    // store empty cell coordinates
                    empties.add(new int[]{r, c});
                } else {
                    // convert digit '1'..'9' → 0..8
                    int digit = ch - '1';

                    int bit = 1 << digit;

                    rows[r] |= bit;
                    cols[c] |= bit;
                    boxes[boxIndex] |= bit;
                }
            }
        }

        backtrack(board, 0, empties, rows, cols, boxes);
    }

    private boolean backtrack(char[][] board, int index,
                              List<int[]> empties,
                              int[] rows, int[] cols, int[] boxes) {

        // base case → all empties filled
        if (index == empties.size()) {
            return true;
        }

        // choose next empty cell (DFS order)
        int[] pos = empties.get(index);
        int r = pos[0];
        int c = pos[1];
        int boxIndex = (r / 3) * 3 + (c / 3);

        // digits already used
        int used = rows[r] | cols[c] | boxes[boxIndex];

        // allowed digits = bits not used
        int allowed = FULL_MASK & ~used;

        // iterate through set bits in allowed
        while (allowed != 0) {
            // isolate lowest set bit
            int bit = allowed & -allowed;
            // convert bit → digit index (0..8)
            int digit = Integer.numberOfTrailingZeros(bit);

            // place digit
            rows[r] |= bit;
            cols[c] |= bit;
            boxes[boxIndex] |= bit;
            board[r][c] = (char) ('1' + digit);

            // recurse
            if (backtrack(board, index + 1, empties, rows, cols, boxes)) {
                return true;
            }

            // undo placement (backtrack)
            rows[r] &= ~bit;
            cols[c] &= ~bit;
            boxes[boxIndex] &= ~bit;
            board[r][c] = '.';

            // remove this bit and continue
            allowed ^= bit;
        }

        // no digit worked → backtrack failure
        return false;
    }
}


/*

has to fully solve the sudoku boardb

given initial board - empty represented by '.

bitmask for rows columns and the 3x3 boxes
    can compare and go through this faster

create arrays to store r, c, b

list to store the empty cells found in the board

iterate through each [][]
    if its empty --  add it to the list
        else, create the related bit representation and place it into row, col, box array for


    backtrack -- to be able to then go through all of the empty spots (recrusive stack)
        when all empty cells are filled we are done
        go thru the empty cells, and then use the bitmask to find out whats already used in each roww col and box, and then use bit comparisons to find potential candidate

ti



*/