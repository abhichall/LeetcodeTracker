class Solution {
    public int numSquares(int n) {

        //edge case
        if (n <= 0) return 0;
        
        //case 1 - if n itself is a perf ect square return 1
        if (isPS(n)) return 1; 

        //case 2 - if two values make up n -- a^2 + b ^2
        int sr = (int) Math.sqrt(n);

        for (int i = 1; i <= sr; i++) {
            int remainder = n - (i * i);

            if (isPS(remainder)) { //works if first is square and os it this 
                return 2;
            }
        }

        //Case 3 - have to use the 3-square and 4 square theorom
            // as per la granges 4 square theorom -- we know that nay number can be represented by 4 squares
            // but question is asking for minimum -- so here we can also follow up the 3 - square theorom
                // way it works is 
                    //continousluy divide by 4 until theres a remainer
                    //if remainder is 7 -- has to be 4
                        //anything but 7, is a totla of 3

        int temp = n;

        while (temp % 4 == 0) {
            temp /= 4;
        } 
        if (temp % 8 == 7) {
            return 4;
        } 

        return 3;
    }

    private boolean isPS(int x) {
        int val = (int) Math.sqrt(x);
        return val * val == x;
    }
}

/**

12
    3
        4 + 4 + 4

case

    n itself is a square -- can be checked by taking the sqr root and resquaring it

    


 */