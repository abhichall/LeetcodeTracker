public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        backtrack(candidates, target, 0, currentCombination, result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> currentCombination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
       
        for (int i = start; i < candidates.length; i++) {
            // If the candidate exceeds the target, skip it
            if (candidates[i] > target) continue;
           
            // Include the current candidate
            currentCombination.add(candidates[i]);
           
            // Recurse, but don't increment i because we can reuse the same number
            backtrack(candidates, target - candidates[i], i, currentCombination, result);
           
            // Backtrack: remove the last added number to try a new combination
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = solution.combinationSum(candidates, target);
       
        // Printing the result
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}

