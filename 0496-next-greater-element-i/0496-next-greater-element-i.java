class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        //store the number and its next greatest
        Map<Integer, Integer> hmap = new HashMap<>();

        //stack  - for numbers that have no next greater value
        Stack<Integer> stack = new Stack<>();

        //ans
        int[] ans = new int[nums1.length];

        for (int n : nums2) {

            while(!stack.isEmpty() && stack.peek() < n) {
                hmap.put(stack.pop(), n);
            }

            stack.push(n);
        }

        while(!stack.isEmpty()) {
            hmap.put(stack.pop(), -1);
        }

        for(int i = 0; i < nums1.length; i++) {
            ans[i] = hmap.get(nums1[i]);
        }

        return ans;

    }
}