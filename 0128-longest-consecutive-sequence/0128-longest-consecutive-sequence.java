class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> hset = new HashSet<>();

        for (int n : nums) {
            hset.add(n);
        }

        int maxSeq = 0;

        for(int i = 0; i < nums.length; i++) {

            int counter = 1;

            int val = nums[i];

            if (hset.contains(val - 1)) continue;

            if (hset.contains(val + 1)) {
                counter++;
                val++;

                while (hset.contains(val + 1)) {
                    counter++;
                    val++;
                }
            }

            maxSeq = Math.max(counter, maxSeq);
        }

return maxSeq;
    }
}