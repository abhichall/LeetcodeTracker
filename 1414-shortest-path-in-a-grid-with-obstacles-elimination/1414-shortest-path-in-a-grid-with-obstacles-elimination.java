class Solution {

    //consisten thru the code -- directional movement
    int[][] directions = { {1,0}, {-1, 0}, {0, 1}, {0, -1} };

    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;    //rows
        int n = grid[0].length; //cols
        //edge
        if (m == 1 && n == 1) return 0; 

        //matrix to store visited
        //the value at each index to represent the minimum # of elims to reach that
        int[][] visited = new int[m][n];
        
        //keep track of what was visited and what hasnt been yet, to avoid duplicates and efficiency right
        for(int[] row : visited) Arrays.fill(row, -1);
        //since we know th start will always have 'k' obstacles to hit left
        visited[0][0] = k;

        //BFS implemention -- want to store [row, col, remainingElims] -- deque j for future flexibility 
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, k});

        //var for step count
        int step = 0;

        while(!q.isEmpty()) {

            int size = q.size();
            step++; //every iteration is one step

            //get all the values from the stores
            for(int i = 0; i < size; i++) {
                int[] curr = q.poll();

                //extract all values needed
                int row = curr[0];
                int col = curr[1];
                int rem = curr[2];

                //explore each neighbor
                for( int[] d : directions) {
                    int newRow = row + d[0];
                    int newCol = col + d[1];

                    //since we have new rows and cols, we have to make sure the bounds are still good
                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) continue;

                    //find the remaining elementations for each direction
                    int newRem = rem - grid[newRow][newCol];

                    //check if rem is left
                    if (newRem < 0) continue;

                    //if dest is reached, we can return steps
                    if (newRow == m - 1 && newCol == n - 1) return step;

                    //if dest is not reached yet, we check to see minimum
                    if(visited[newRow][newCol] >= newRem) continue;         //this means that this newRem val is not a minimum
                    
                    //new remaining IS A MINIMUM
                    visited[newRow][newCol] = newRem;

                    q.offer(new int[] {newRow, newCol, newRem});


                }

            }

        }

        return -1;


        
    }
}

/**

INPUT -- 2D Array, integer k (obstacles we can eliminate)
OUTPUT -- MINIMUM number of steps to go from grid[0][0] to grid[m-1][n-1]

IDEAS

    Explore all possible paths (DFS)
        keep track of how many obstacles till end; compare it with k; hold that val
        

    BFS 
        Traverse each level/direct neighbor -- ensure that we keep it to minimal steps
        
        hold states [row, col, remainingK]
        matrix for visited, then we can only add to our bfs values that imprpove upon previous



 */