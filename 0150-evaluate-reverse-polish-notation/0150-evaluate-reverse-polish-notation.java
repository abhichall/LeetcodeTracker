class Solution {
    public int evalRPN(String[] tokens) {

        //push onto stack until an operator
        // then pop last two numbers
        //perform related operation
        //push back onto stack 

        //create a stack of numbers
        Stack<Integer> stack = new Stack();

        //go thru each string within the array
        for (String s : tokens) {
            
            //this would indicate an operation needed, if not then j push it on stack
            if( s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*") ) {

            //the integer values
            int x = stack.pop();
            int y = stack.pop();

            //do the operation and push the restul back onto the stack
                if(s.equals("+")) {
                    int sum = x+y;
                    stack.push(sum);
                } else if (s.equals("-")) {
                    int diff = y-x;
                    stack.push(diff);
                } else if (s.equals("*")) {
                    int mult = x * y;
                    stack.push(mult);
                } else if (s.equals("/")) {
                    int qu = y / x;
                    stack.push(qu);
                }

            } else {
            
            //other than the operations, it will ALWAYS be in an int
            //make the string type into an int
            int num = Integer.parseInt(s);
            //push this onto the stack
            stack.push(num);
        }}

        //at the end, the final result will be in th stack
        return stack.pop();

        
    }
}