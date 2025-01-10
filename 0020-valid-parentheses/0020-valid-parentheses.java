class Solution {
    public boolean isValid(String s) {

        //stack because we need to see the most recent addition in roder to check for validity
        Stack<Character> stack = new Stack();

        //so this can be iterated through
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if(stack.isEmpty()) return false;

            if ( c == ')' && stack.pop() != '(') return false;
            if ( c == '}' && stack.pop() != '{') return false;
            if ( c == ']' && stack.pop() != '[') return false;


        }

        if (stack.isEmpty()) return true;
        return false;

        
    }
}