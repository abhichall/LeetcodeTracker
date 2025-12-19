class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean alive = true;

            // collision only if stack top > 0 and current < 0
            while (alive && !stack.isEmpty() && stack.peek() > 0 && a < 0) {

                int top = stack.peek();

                if (Math.abs(top) < Math.abs(a)) {
                    // top explodes
                    stack.pop();
                } else if (Math.abs(top) == Math.abs(a)) {
                    // both explode
                    stack.pop();
                    alive = false;
                } else {
                    // current explodes
                    alive = false;
                }
            }

            if (alive) {
                stack.push(a);
            }
        }

        // convert stack to array
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}

/**


given - int array asteroids -- numbers - -/+ represents directions && |x| - represents size 
output - int array -- return the same array - only return the state 
        if x > y - y explodes
           x = y - both explode


ideas
    brute force - scan entire array mjultipls time to find adjacent and realtive values - o n^2

    stack - 
    -- represtn 1d
        new ast = post - push

        when i get a negative asteroid

         keep astroinds that are moving

 */