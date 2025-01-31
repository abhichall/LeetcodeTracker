class Solution {
    public boolean containsDuplicate(int[] nums) {

        int n = nums.length;

        Set<Integer> hset = new HashSet<>();

        for (int num : nums) {
            hset.add(num);
        }
        
        if (hset.size() == n) {
            return false;
        } else {
            return true;
        }

    }
}