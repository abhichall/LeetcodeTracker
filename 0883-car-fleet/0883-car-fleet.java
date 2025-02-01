class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        //return the number of fleets
        //arrival time will determine fleets?
        Stack<Double> stack = new Stack();

        //wanna store pos and speed pairs
        int[][] speedPos = new int[position.length][2];

        for(int i = 0; i < position.length; i++) {
            speedPos[i][0] = position[i];
            speedPos[i][1] = speed[i];
        }

        //sort by position
        Arrays.sort(speedPos, (a,b) -> Integer.compare(a[0], b[0]));



    for(int i = speedPos.length - 1; i >= 0; i--) {

        double time = (double) (target - speedPos[i][0]) / speedPos[i][1];


        if(!stack.isEmpty() && time <= stack.peek()) continue;

        stack.push(time);

        //if times are equal = same fleet
        //if car x is ahead of car y, but car y has less time to target, same flee

    }

    return stack.size();

    }
}