class Solution {
    private static final int[][] DIRS = {
        { 2, 1}, { 2,-1}, {-2, 1}, {-2,-1},
        { 1, 2}, { 1,-2}, {-1, 2}, {-1,-2}
    };


    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        if (y > x) { int t = x; x = y; y = t; } // enforce x >= y

        int minX = -2, minY = -2;
        int maxX = x + 2, maxY = y + 2;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 0}); // (cx, cy, dist)

        boolean[][] seen = new boolean[maxX - minX + 1][maxY - minY + 1];
        seen[0 - minX][0 - minY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1], d = cur[2];
            if (cx == x && cy == y) return d;

            for (int[] mv : DIRS) {
                int nx = cx + mv[0];
                int ny = cy + mv[1];

                if (nx < minX || nx > maxX || ny < minY || ny > maxY) continue;

                int ix = nx - minX, iy = ny - minY;
                if (seen[ix][iy]) continue;
                seen[ix][iy] = true;
                q.add(new int[]{nx, ny, d + 1});
            }
        }

        // Guaranteed to exist, so we should never get here.
        return -1;
    }
}
