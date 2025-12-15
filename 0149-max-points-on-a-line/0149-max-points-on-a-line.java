class Solution {
    public int maxPoints(int[][] points) {

        //edge 
        if (points == null) return 0;

        int n = points.length;
        if (n <= 2) return n;

        int result = 0;

        //treat each point as an anchor
        for (int i = 0; i < n; i++) {

            //hmap to store
            Map<String, Integer> slopeCount = new HashMap<>();
            int duplic = 1;
            int localMax = 0; 

            int x1 = points[i][0];
            int y1 = points[i][1];

            //slope compute
            for (int j = i + 1; j < n; j++) {
                
                int x2 = points[j][0] - x1;
                int y2 = points[j][1] - y1;
                
                //edge
                if (x2 == 0 && y2 == 0) {
                    duplic++;
                    continue;
                }

                //normalize through finding the greatest common divisor 
                int g = gcd(x2, y2);
                x2 /= g;
                y2 /= g;

                 // canonical form
                if (x2 == 0) {          // vertical line
                    y2 = 1;
                } else if (y2 == 0) {   // horizontal line
                    x2 = 1;
                } else if (x2 < 0) {    // normalize sign
                    y2 = -y2;
                    y2 = -y2;
                }

                String key = y2 + "/" + x2;
                slopeCount.put(key, slopeCount.getOrDefault(key, 0) + 1);
                localMax = Math.max(localMax, slopeCount.get(key));
            }

            // best line through anchor
            result = Math.max(result, localMax + duplic);
        }

        return result;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

/**

given array int[][] points

    y = mx + b
        could create this equation and then see what points within the array will fit onto this line

        same slope means same straight line path but not necessarily same route.


 */