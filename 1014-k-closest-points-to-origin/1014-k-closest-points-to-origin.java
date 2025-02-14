class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        //2d array - (x, y)
        //within the points array - output, in 2d array form - the k closest points

        //we need to sort based on distance to the origin
            //arrays.sort() - custom comparator to sort based on distance from origin
            
            // compare method - compare 
                                            // [x,y] [x,y] etc
            //after sorting we can j return first k elemnts 
        
        Arrays.sort(points, new Comparator<int[]> () {

            public int compare(int[] point1, int[] point) {
                int distance1 = point1[0] * point1[0] + point1[1] * point1[1]; //calc the squared distances from point1 to the origin
                int distance2 = point[0] * point[0] + point[1] * point[1]; //calc the squared sistances from popint 2 to the orign

                return distance1 - distance2;  //diff between distance 
            }

        });

        return Arrays.copyOfRange(points, 0, k); //iterate thru points, find the k closest values to 90



    }
}