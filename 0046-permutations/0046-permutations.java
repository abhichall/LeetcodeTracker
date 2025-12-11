class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        //edge case
        if (nums == null) return results;

        //call backtrackin
        backtrack(nums, 0, results);

        return results;
    }

    public void backtrack(int[] nums, int start, List<List<Integer>> results) {

        //base case
        if (start == nums.length) {
            //valid permutation
            List<Integer> perms = new ArrayList<>();
            for (int v : nums) perms.add(v);
            results.add(perms);
            return;
        }

        //try every possibile candidate within the permutation
        for (int i = start; i < nums.length; i++) {

            //put nums[i] at start
            swap(nums, start, i);

            //then call recurisons on next 
            backtrack(nums, start+1, results);

            //get the original back
            swap(nums, start, i);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**

just want use to return all permutations
    got it
could have a boolean array to store what permutionas - math formula to find ho wmany possible (factoruals)
    would be pretty memroy intesinve

recurstion method -- maybe backtracking
    
    method 
        have a fixed value at the beginning
        can use recursino to fill in the next position
            have a fixed there and so on
    this will all happen in memory and also will be efficient in time wise



 */