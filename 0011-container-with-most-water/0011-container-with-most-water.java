class Solution {
    public int maxArea(int[] height) {

        int maxVolume = 0;
        int h = 0;
        int width = 0;

        int currTotal = 0;

        int i = 0;
        int k = height.length - 1;


            while ( k > i) {
                width = k - i;
                h = Math.min(height[i], height[k]);

                currTotal = h * width;

                maxVolume = Math.max(maxVolume, currTotal);

                if (height[i] > height[k]) {
                    k--;
                } else {
                    i++;
                }

        }



        return maxVolume;
        
    }
}