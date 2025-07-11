class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> hset = new HashSet<>();

        for(int i : nums) {
            hset.add(i);
        }

        if (hset.size() == nums.length) {
            return false;
        }

        return true;
        
    }
}