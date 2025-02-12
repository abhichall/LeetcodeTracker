class Solution {
public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1]; // Array to store max values
        Deque<Integer> dq = new ArrayDeque<>(); // Stores indices in decreasing order

        for (int i = 0; i < n; i++) {
            // Remove elements out of the current window
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            // Remove elements from the back if they are smaller than the current element
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current element index
            dq.offerLast(i);

            // Append max of the window to result (only after the first k-1 elements are processed)
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        
        return result;
    }
}
