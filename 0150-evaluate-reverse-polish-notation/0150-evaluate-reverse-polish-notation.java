class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack();

        for (String s : tokens) {

            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {

                int x = stack.pop();
                int y = stack.pop();
                
                if(s.equals("+")) {
                    stack.push(x+y);
                } else if (s.equals("-")) {
                    stack.push(y-x);
                } else if (s.equals("*")) {
                    stack.push(x*y);
                } else if (s.equals("/")) {
                    stack.push(y/x);
                }

            } else {

        int num = Integer.parseInt(s);
        stack.push(num);
        }}

        return stack.pop();
        
    }
}