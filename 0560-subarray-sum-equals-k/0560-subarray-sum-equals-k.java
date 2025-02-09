class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, 1); //this is a default value and will allow for us to compensate for sum = k

        int count = 0;
        int prefixSum = 0;
        int diff = 0;

        for (int num : nums) {

            prefixSum = prefixSum + num;
            diff = prefixSum - k;


            if(hmap.containsKey(diff)) {
                count = hmap.get(diff) + count;
            }

            hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}