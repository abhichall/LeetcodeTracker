class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<String> hset= new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                char val = board[i][j];

                if (val != '.') {
                    
                    if( !hset.add(val + "at row" + i) || !hset.add(val + "at col" + j) || !hset.add(val + "in box" + i/3 + j/3)){
                        return false;
                    }

                }

            }
        }

     return true;   
    }
}