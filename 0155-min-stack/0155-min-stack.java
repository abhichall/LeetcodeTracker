class MinStack {

    //make a variable to track min
    //set it to the maximum value of integer so that it can be set to first value for min
    int min = Integer.MAX_VALUE;

    //intializes one stack for the rest of the code
    // no need for first function
    Stack<Integer> stack = new Stack();
    
    public void push(int val) {

        //we want to be able to store previous min right before the new min
        if( val <= min) {
            stack.push(min); //pushes the current min onto the stack so that when new min is popped, old min is still accessible
            min = val;
        }

        stack.push(val);
        
    }
    
    public void pop() {

        //if the popped value is the current min, then pop again since in the push we pushed an extra "old" min value and store it as min
        if(stack.pop() == min) {
            min = stack.pop();
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        
        // while (!stack.isEmpty()) {
        //     System.out.println(stack.pop());
        // }
        return min;
        
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */