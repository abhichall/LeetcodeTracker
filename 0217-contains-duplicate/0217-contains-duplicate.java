class Solution {
    public boolean containsDuplicate(int[] nums) {

        //make a hashset
        Set<Integer> hset = new HashSet<>();

        //add all values in the nums array to hset
        for (int n : nums) {
            hset.add(n);
        }
        
        //if the sizes are equals that means there are no duplicates
        if (hset.size() == nums.length) {
            return false;
        } else {
            return true; 
        }

    }
}