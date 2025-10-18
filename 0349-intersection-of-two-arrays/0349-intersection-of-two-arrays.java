class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        //for optimaization, can switch around nums1 and nums2
        if(nums1.length > nums2.length) return intersection(nums2, nums1);

        Set<Integer> hset = new HashSet<>();
        for(int n: nums1) {
            hset.add(n);
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int n : nums2) {
            if(hset.contains(n)) {
                resultSet.add(n);
            }
        }

        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int v : resultSet) {
            result[i++] = v;
        }
        return result;
    }
}