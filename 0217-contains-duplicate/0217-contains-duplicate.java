class Solution {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> hset = new HashSet<>();
        for (int n:nums) hset.add(n);

        if(hset.size() != nums.length) {
            return true;
        }
        return false;
    }
}