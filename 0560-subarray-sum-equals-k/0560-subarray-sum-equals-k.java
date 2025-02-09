class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> hmap = new HashMap<>();
        hmap.put(0, 1); // Default case: prefix sum of 0 appears once

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num; // Update the running sum
            
            // Check if (prefixSum - k) exists in map
            if (hmap.containsKey(prefixSum - k)) {
                count += hmap.get(prefixSum - k);
            }

            // Update the frequency of the prefix sum
            hmap.put(prefixSum, hmap.getOrDefault(prefixSum, 0) + 1);
        }

        return count; 
    }
}