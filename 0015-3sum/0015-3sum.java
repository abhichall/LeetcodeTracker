class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            
            //duplications
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if(sum > 0) k--;
                if(sum < 0) j++;
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                        while(j < k & nums[j] == nums[j-1]){
                             j++;
                        }
                }
            }
        }

        return result;
    }
}