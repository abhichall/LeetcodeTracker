class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int j = 0;
        int k = numbers.length - 1;

        while (j < k) {

            int sum = numbers[j] + numbers[k];

            if (sum > target) k--;
            if (sum < target) j++;

            if (sum == target) return new int[] {j+1, k+1};
            
        }

        return new int[]{};
        
    }
}