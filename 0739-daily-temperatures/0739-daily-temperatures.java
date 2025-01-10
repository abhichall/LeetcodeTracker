class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        //length
        int n = temperatures.length;

        //int array for answer
        int[] answer = new int[n];

        //we can use a stack since we only care about next largest
        Stack<Integer> stack = new Stack();

        //we can store indexes within the stack
        for(int i = 0; i < n; i++) {

            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }

            stack.push(i);

        }

        return answer;
    }
}