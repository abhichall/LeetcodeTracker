class Solution {
    public int orangesRotting(int[][] grid) {
        // edge case
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> rotten = new LinkedList<>();
        
        // First pass: count fresh oranges and collect rotten ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    freshOranges++;
                } else if (grid[r][c] == 2) {
                    rotten.offer(new int[]{r, c});
                }
            }
        }
        
        // If no fresh oranges, return 0
        if (freshOranges == 0) return 0;
        
        int minutes = 0;
        // Similar to directions we used in numIslands
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        // BFS instead of DFS (sink)
        while (!rotten.isEmpty() && freshOranges > 0) {
            minutes++;
            int size = rotten.size();
            
            // Process all rotten oranges at current minute
            for (int i = 0; i < size; i++) {
                int[] curr = rotten.poll();
                
                // Check all 4 directions (like in sink)
                for (int[] dir : dirs) {
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];
                    
                    // Similar boundary checks as sink
                    if (newRow < 0 || newCol < 0 || newRow >= rows || 
                        newCol >= cols || grid[newRow][newCol] != 1) {
                        continue;
                    }
                    
                    // Make orange rotten
                    grid[newRow][newCol] = 2;
                    freshOranges--;
                    rotten.offer(new int[]{newRow, newCol});
                }
            }
        }
        
        // If there are still fresh oranges, impossible
        return freshOranges == 0 ? minutes : -1;
    }
}
