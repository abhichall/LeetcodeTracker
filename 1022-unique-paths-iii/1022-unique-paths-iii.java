class Solution {

    int[] dR = {0,0,1, -1};
    int[] dC = {1, -1, 0, 0};

    public int uniquePathsIII(int[][] grid) {

        //get values
        int rows = grid.length, cols = grid[0].length;
        int startR = 0, startC = 0;
        int valid = 0; //counter for valid path steps
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                //make sure my paths only are one valid steps
                if(grid[r][c] != -1) valid++;

                //find starting val
                if(grid[r][c] == 1) {
                    startR = r;
                    startC = c;
                }
            }
        }
            return dfs(grid, startR, startC, valid);
    }

private int dfs (int[][] grid, int r, int c, int remaining) {

        //need to check bounds 
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == -1) return 0;

        //if the value we access is 2 -- we reached the end
        //1 accounts for the step from index to finish //must use all steps, this will b 0 -- no valid path
        if(grid[r][c] == 2) {
            return (remaining == 1) ? 1 : 0;  
        }

        //store temp from the grid -- set to -1
        int temp = grid[r][c];
        grid[r][c] = -1;

        int counter = 0;

        for (int k = 0; k < 4; k++) { //iterate thru directions 

            int nr = r + dR[k];
            int nc = c + dC[k];
             
            counter = counter + dfs(grid, nr, nc, remaining - 1);
        }

        //since dfs calls this recursively 
        grid[r][c] = temp;

        //by this point it should have proper values
        return counter;
    }
        
    }

/**


at every index, there is 4 options

input -- grid (2D)
output -- # of a 4 directional walks

4 directional walk
- gtting from start to end and ONLY moving up, down, left, right

DFS - allows for us to explore all paths, to return the # of 4-directional walks

move in all 4 directions
mark as visited
decrement the cells

locate the start
count the amount of walkable steps (including start and end)
implement dfs
    from start
    use the number of walkable areas

 */