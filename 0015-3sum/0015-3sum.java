class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        //what the answer wants
        List<List<Integer>> list = new ArrayList<>();

        //sort the array
        Arrays.sort(nums);


        // length - 2 so that left is always behind right
        for (int i = 0; i < nums.length - 2; i++) {

         int j = i + 1; 
        int k = nums.length-1;

        if ( i > 0 && nums[i] == nums[i-1]) continue; //avoids duplicate checking

        while ( j < k) {
            int sum = nums[i] + nums[j] + nums[k];

            if (sum > 0) {
                k--;
            } else if(sum < 0) {
                j++;
            } else {
                list.add(Arrays.asList(nums[i], nums[j], nums[k]));
            

            while( j < k && nums[j] == nums[j+1]) j++;
            while( j < k && nums[k] == nums[k-1]) k--;

            j++;
            k--;
        }}}

        return list;
        
    }
}