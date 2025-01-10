class Solution {
    public int[] twoSum(int[] nums, int target) {

        //make a hashmap
        Map<Integer, Integer> hmap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            

            Integer index = hmap.get(nums[i]);

            if (index == null) {
                hmap.put(target - nums[i], i);
            }

            if (index != null) {
                return new int[] {index, i};
            }


        }

        return new int[] {};
        
    }
}