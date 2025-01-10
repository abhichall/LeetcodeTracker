class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        //create a stack, to store, and be able to look at cars in fleets prev
        Stack<Double> stack = new Stack();
        
        //lets create a 2d array so that we can store the pos/speed pairs together 
        int[][] speedPos = new int[position.length][2];

        //we can populate the 2d array thru
        for(int i = 0; i < position.length; i++) {
            speedPos[i][0] = position[i];
            speedPos[i][1] = speed[i];
        }

        //now we can sort this pairs from least to greatest using a lambda function
        Arrays.sort(speedPos, Comparator.comparingInt(element -> element[0]));

    //now that array is sorted - can conlude that if car y is behind car x, but car y has a shorter time to reach target than car x, then car y and car x will become part of the same fleet

    //so we iterate from right, and push onto stack, if time of curr is <= stack.peek then same fleet

    for(int i = speedPos.length - 1; i >= 0; i--) {

        double time = (double) (target - speedPos[i][0]) / speedPos[i][1];
        
        if(!stack.isEmpty() && time <= stack.peek()) {
            continue;
        }
        stack.push(time);
    }

    return stack.size();

    }
}