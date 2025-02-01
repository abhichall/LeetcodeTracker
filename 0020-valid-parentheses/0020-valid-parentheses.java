class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();

        char[] arr = s.toCharArray();

        for (char c : arr) {

            if ( c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            if (stack.isEmpty()) return false;

            if ( c == ')' && stack.pop() != '(') return false;
            if ( c == ']' && stack.pop() != '[') return false;
            if ( c == '}' && stack.pop() != '{') return false;

        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }
}