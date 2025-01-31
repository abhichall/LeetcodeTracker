class Solution {
    public int maxArea(int[] height) {

        int maxVol = 0;
        int curr = 0;
        int j = 0;
        int k = height.length - 1;

        while (j < k) {
            
            int h = Math.min(height[j], height[k]);
            int width = k - j;

            curr = width * h;

            maxVol = Math.max(curr, maxVol);

            if (height[j] >= height[k]) {
                k--;
            } else if (height[j] < height[k]) {
                j++;
            }
        }
           return maxVol;
    }
}