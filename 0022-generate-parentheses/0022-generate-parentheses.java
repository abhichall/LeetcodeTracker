class Solution {
    public List<String> generateParenthesis(int n) {

        //answer
        List<String> list = new ArrayList<>();

        // backtracking
        backtrack(list, "", 0, 0, n);

        return list;

        
    }

    public void backtrack(List<String> list, String current, int open, int closed, int max) {
        
        //every function has a base case for when a value should be done or smt
        
        //since n = max number of pairs - when length = n*2, should be added to list
        if(current.length() == max *2) {
            list.add(current);
        }


        if( open < max) backtrack(list, current + "(", open + 1, closed, max);

        if( closed < open) backtrack(list, current + ")", open, closed + 1, max);

    }
}